package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Creare la classe Labirinto e modificare la
classe Partita affinché non abbia la
responsabilità della creazione del labirinto
– Un labirinto ha una entrata (stanza di ingresso)
ed una uscita (stanza vincente)
– La classe Labirinto ha un metodo privato
init() che inizializza il labirinto

• Provare ad eseguire il codice del gioco prima e
dopo le modifiche e verificare che il 
comportamento sia rimasto invariato
 * @author lavinia
 *
 */

public class Labirinto {
	private Stanza entrata;	//stanza di ingresso
	private Stanza uscita;	//stanza vincente	
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	public void setUscita(Stanza s) {
		this.uscita=s;		
	}
	
	public void setEntrata(Stanza s) {
		this.entrata=s;
	}
	
	public Stanza getEntrata() {
		return this.entrata;
	}
	public Stanza getUscita() {
		return this.uscita;
	}
}
