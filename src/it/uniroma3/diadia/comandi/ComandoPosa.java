package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	private IO io = new IOConsole();
	private static final String NOME = "posa";
	
	public ComandoPosa (String nome) {
		this.nomeAttrezzo = nome;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().getNumeroAttrezzi() == 0) 
			io.mostraMessaggio("non c'e' l'attrezzo nella borsa");
		else {
			if(nomeAttrezzo == null) {
				io.mostraMessaggio("che attrezzo vuoi prendere?");
				return;
			}
			
			if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo))
				io.mostraMessaggio("attrezzo inesistente");
		  else {
			Attrezzo attrezzo = new Attrezzo();
			attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getLabirinto().getEntrata().addAttrezzo(attrezzo);
		  }
		}
	}

	@Override
	public String getNome() {
		return this.NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
