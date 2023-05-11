package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
    private String attrezzo;
    
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzo = attrezzo;
	}
	
	public String getDescrizione () {
		StringBuilder s = new StringBuilder();
		
		if((this.hasAttrezzo(this.attrezzo))) {
			s.append(super.getDescrizione());
		}
	
		else {
			s.append("qui c'e' un buio pesto");
		}
	  return s.toString();
	}
}
