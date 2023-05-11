package it.uniroma3.diadia.ambienti;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	
	private String nome;
	protected Map<String, Attrezzo> attrezzi;
    protected int numeroAttrezzi;
    private Map<String, Stanza> stanze;
    private int numeroStanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.attrezzi = new HashMap<String, Attrezzo>();
        this.stanze = new HashMap<String, Stanza>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
		if(this.attrezzi.containsKey(direzione)) {
			this.stanze.put(direzione, stanza);
			aggiornato = true;
		}
		
    	if (!aggiornato) {
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.stanze.put(direzione, stanza);
    			this.numeroStanzeAdiacenti++;
    		}
    	}	
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
	  if(this.stanze.containsKey(direzione))
	 	return this.stanze.get(direzione);
	  return null;
	  }

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String, Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    
    public int getNumeroAttrezzi () {
		return this.numeroAttrezzi;
	}

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */


    public boolean addAttrezzo(Attrezzo attrezzo) {
     if(! this.hasAttrezzo(attrezzo.getNome())) {
    	this.attrezzi.put(attrezzo.getNome(), attrezzo);
    	this.numeroAttrezzi++;
    	return true;
     }
     else
    	return false;
    }
    

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	risultato.append(getDirezioni());
    	
	    risultato.append("\nAttrezzi nella stanza: ");
	    if(this.numeroAttrezzi != 0)  {
	    	for (Attrezzo attrezzo : this.attrezzi.values()) {
	    		if(attrezzo != null)  {
	    			risultato.append(attrezzo.toString()+" ");
	    		}
	    	}
    	}
	    else 
    	  risultato.append("stanza vuota");
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/

	
	public boolean hasAttrezzo (String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	
	public Attrezzo getAttrezzo (String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */

	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.hasAttrezzo(attrezzo.getNome())) {
			this.attrezzi.remove(attrezzo.getNome());
			this.numeroAttrezzi--;
		return true;
		}
		return false;
	}


	public Set<String> getDirezioni() {
		return this.stanze.keySet();
	   }

}
