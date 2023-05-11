package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Map<String, Stanza> mappa;
	private Labirinto lab;
	private Stanza ultimaStanza;
	
	public LabirintoBuilder() {
		this.lab = new Labirinto();
		this.mappa = new HashMap<String, Stanza>(); 
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaIniziale(String iniziale) {
		Stanza s = new Stanza(iniziale);
		this.mappa.put(iniziale, s);
		this.lab.setEntrata(s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String vincente) {
		Stanza s = new Stanza(vincente);
		this.mappa.put(vincente, s);
		this.lab.setUscita(s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	
	public void ultimaStanzaAggiunta(Stanza s) {
		this.ultimaStanza = s;
		 
	}
	
	public Stanza getUltimaStanzaAggiunta() {
		return this.ultimaStanza;
	}
	
	public Labirinto getLabirinto() {
		return this.lab;
	}
	
	public LabirintoBuilder addAttrezzo(String nome,int peso) {
		Attrezzo a = new Attrezzo(nome,peso);
		if(this.ultimaStanza==null)
			return this;
		this.ultimaStanza.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String corrente,String adiacente,String direzione) {
		Stanza c =  this.mappa.get(corrente);
		Stanza a = this.mappa.get(adiacente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		Stanza s = new StanzaMagica(nome,soglia);
		this.mappa.put(nome,s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzo) {
		Stanza s = new StanzaBuia(nome,attrezzo);
		this.mappa.put(nome, s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzo, String direzioneBloccata) {
		Stanza s = new StanzaBloccata(nome,attrezzo,direzioneBloccata);
		this.mappa.put(nome, s);
		this.ultimaStanzaAggiunta(s);
		return this;
	}

}
