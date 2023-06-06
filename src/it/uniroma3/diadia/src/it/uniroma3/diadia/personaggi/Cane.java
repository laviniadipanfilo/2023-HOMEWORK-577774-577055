package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private final static String MORSO_CANE = "Hai perso un CFU!";
	private final static String CIBO_PREFERITO = "osso";
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MORSO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	return msg;
	}
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder msg = new StringBuilder("Grazie!");
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			msg.append("E' proprio il mio cibo preferito!");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("gioco per cani",1));
		}
		else {
			msg.append("Sfortunatamente non e' il mio cibo preferito, dunque ti mordero'!");
			this.agisci(partita);
		}
	return msg.toString();
	}

}
