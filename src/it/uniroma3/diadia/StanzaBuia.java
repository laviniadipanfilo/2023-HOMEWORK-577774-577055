package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaBuia extends Stanza {
    private String attrezzo;
    
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzo = attrezzo;
	}
	
	public String getDescrizione () {
		StringBuilder buffer = new StringBuilder();
		
		if(this.hasAttrezzo(this.attrezzo)) {
			buffer.append(super.getDescrizione());
		}
	
		else {
			buffer.append("qui c'e' un buio pesto"); 
		}
	  return buffer.toString();
	}
}
