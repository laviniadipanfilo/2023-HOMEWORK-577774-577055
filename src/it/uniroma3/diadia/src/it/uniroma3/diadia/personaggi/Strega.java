package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	private final static String MESSAGGIO_SALUTATA = "Grazie per avermi salutato! "
			+ "Ti mandero' nella stanza con piu' attrezzi";
	
	private final static String MESSAGGIO_NON_SALUTATA = "Vista la tua maleducazione, "
			+ "ti mandero' nella stanza con meno attrezzi";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanze = partita.getStanzaCorrente().getStanzeAdiacenti();
		
		Stanza massimo = stanze.get(0);
		Stanza minimo = stanze.get(0);
		
		for(Stanza i : stanze) {
			if(i != null) {
				if(massimo.getNumeroAttrezzi() < i.getNumeroAttrezzi()) {
					massimo = i;
				}
				if(minimo.getNumeroAttrezzi() > i.getNumeroAttrezzi()) {
					minimo = i;
				}
			}
		}
		
		if(this.haSalutato()) {
			partita.setStanzaCorrente(massimo);
			msg = MESSAGGIO_SALUTATA;
		}
		else {
			partita.setStanzaCorrente(minimo);
			msg = MESSAGGIO_NON_SALUTATA;
		}
	return msg;
	}
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHAHAHAHAHAHAHAHAHAHA";
	}

}
