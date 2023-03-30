package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Giocatore giocatore = new Giocatore();
	private IOConsole io;

	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.io = console;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
        if(comandoDaEseguire.getNome() == null) {
        	this.io.mostraMessaggio("Non hai inserito il comando!");
        }
		else 
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			System.exit(1);
			return true;
		} else
			return false;
		
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare?");
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
			String istruzione;		
    		do		
    			istruzione = this.io.leggiRiga();
    		while (!processaIstruzione(istruzione)); // prende l'istruzione fino a quando non vinco
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		System.exit(1);
	}
	
	// attrezzo RIMOSSO dalla STANZA e AGGIUNTO nella BORSA
	private void prendi (String nomeAttrezzo) {
		if(this.partita.getStanzaCorrente().getNumeroAttrezzi() == 0) 
			this.io.mostraMessaggio("Non ci sono attrezzi nella stanza");
		else {
			if(nomeAttrezzo == null) {
				this.io.mostraMessaggio("Che attrezzo vuoi prendere?");
				this.partita.getStanzaCorrente().toString();
				String istruzione;		
	            do		
	    			istruzione = this.io.leggiRiga();
	    		while (!processaIstruzione(istruzione)); // prende l'istruzione fino a quando non vinco
			}
			
			 // ho trovato l'attrezzo
			this.io.mostraMessaggio(nomeAttrezzo+" preso/a");
			
			if(!this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) 
				this.io.mostraMessaggio("Attrezzo inesistente\n");
			else {
				
				Attrezzo attrezzo = new Attrezzo();
				attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				
				int cfu = this.giocatore.getCfu();
				this.giocatore.setCfu(cfu--);
			    this.partita.getStanzaCorrente().removeAttrezzo(attrezzo); // ho rimosso l'attrezzo
			    this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo); // ho preso l'attrezzo
			}
	    }
	}
	
	// attrezzo RIMOSSO dalla BORSA e AGGIUNTO nella STANZA
	public void posa(String nomeAttrezzo) {		//attrezzi rimosssi dalla borsa e messi nella stanza
		if(this.partita.getGiocatore().getBorsa().getNumeroAttrezzi() == 0) 
			this.io.mostraMessaggio("Non ci sono attrezzi nella borsa");
		else {
			if(nomeAttrezzo == null) {
				this.io.mostraMessaggio("Che attrezzo vuoi posare?");
				this.partita.getStanzaCorrente().toString();
				String istruzione;		
	            do		
	    			istruzione = this.io.leggiRiga();
	    		while (!processaIstruzione(istruzione)); // prende l'istruzione fino a quando non vinco
			}
			
			if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo))
				this.io.mostraMessaggio("Attrezzo inesistente\n");
			else {
				this.io.mostraMessaggio(nomeAttrezzo+" posato/a");
			Attrezzo attrezzo = new Attrezzo();
			attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo); // ho trovato l'attrezzo			
			if(attrezzo == null) 
				this.io.mostraMessaggio("Attrezzo inesistente\n");
			else {
				int cfu = this.giocatore.getCfu();
				this.giocatore.setCfu(cfu--);
				this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			}
	      }		
		}
	}
	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}