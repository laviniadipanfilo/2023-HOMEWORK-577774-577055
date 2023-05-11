package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendi implements Comando {
	
    private String nomeAttrezzo;
    private IO io = new IOConsole();
    private static final String NOME = "prendi";
    
    public ComandoPrendi (String nome) {
    	this.nomeAttrezzo = nome;
    }
    
	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo = parametro;
	}
    
	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getEntrata().getNumeroAttrezzi() == 0) 
			io.mostraMessaggio("non ci sono attrezzi nella stanza");
		else {
			if(this.nomeAttrezzo == null) {
				io.mostraMessaggio("che attrezzo vuoi prendre?");
				return;
			}
			if(!partita.getLabirinto().getEntrata().hasAttrezzo(nomeAttrezzo))
				io.mostraMessaggio("attrezzo inesistente");
		  else {
			Attrezzo attrezzo = new Attrezzo();
			attrezzo = partita.getLabirinto().getEntrata().getAttrezzo(nomeAttrezzo);
			
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
		    if(partita.getGiocatore().getBorsa().getPeso() + attrezzo.getPeso() <= partita.getGiocatore().getBorsa().getPesoMax()) {
		    	partita.getLabirinto().getEntrata().removeAttrezzo(attrezzo); // attrezzo rimosso
		        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo); // attrezzo preso
		    }
		    
		    else 
		    	System.out.println("Attrezzo troppo pesante!");
		    	
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
