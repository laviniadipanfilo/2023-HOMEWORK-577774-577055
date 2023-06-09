package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
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
	

	private Partita partita;
	private IO io;

	public DiaDia(Labirinto lab, IO console) {
		this.partita = new Partita(lab);
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
	
	public boolean processaIstruzione(String istruzione) {
	  Comando comandoDaEseguire;
	  FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();

	  comandoDaEseguire = factory.costruisciComando(istruzione);
	  comandoDaEseguire.esegui(this.partita);
	
	   if (this.partita.vinta())
         System.out.println("Hai vinto!");
	   if (!this.partita.giocatoreIsVivo())
		 System.out.println("Hai esaurito i CFU...");
	 return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		IO io = new IOConsole();
		
		Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addAttrezzo("chiave", 1)
			.addAttrezzo("martello", 3)
			.addAttrezzo("roccia", 1)
			.addStanzaVincente("Biblioteca")
			.addStanzaBuia("Bagno", "roccia")
			.addStanzaBloccata("Atrio", "chiave", "est")
			.addAdiacenza("LabCampusOne", "Atrio", "sud")
			.addStanzaMagica("Aula Studio",3)
			.addAttrezzo("lampada", 1)
			.addAdiacenza("LabCampusOne", "Bagno", "ovest")
			.addAdiacenza("LabCampusOne", "Aula Studio", "est")
			.addAdiacenza("Aula Studio", "Biblioteca", "nord")
			.addAdiacenza("Atrio", "Aula Studio", "ovest")
			.getLabirinto();
		
	    DiaDia gioco = new DiaDia(labirinto, io);
	    gioco.gioca();
		
	}
}
