package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private int cfu;
	private Giocatore giocatore;
	
	public Partita(){
		this.finita = false;
		Labirinto lab = new Labirinto();
		this.stanzaCorrente = lab.getEntrata();
		this.stanzaVincente = lab.getUscita();
		this.giocatore = new Giocatore();
	}
	
	public Giocatore getGiocatore () {
		return giocatore;
	}
	
	public void setGiocatore (Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		int cfu = giocatore.getCfu();
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}	
	
	public boolean giocatoreIsVivo () {
		if(this.giocatore.getCfu() > 0)
			return true;
		else
			return false;
	}
}

