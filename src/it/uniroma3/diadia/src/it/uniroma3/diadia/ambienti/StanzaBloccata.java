package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String attrezzo;
	private Direzione direzioneBloccata;
	
	public StanzaBloccata(String nome, String attrezzo, Direzione direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzo = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		
		if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.attrezzo)) {
			return this;
		}
		
	  return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione () {
		StringBuilder buffer = new StringBuilder();
		
		if(!this.hasAttrezzo(this.attrezzo)) {
			buffer.append("nella stanza non c'e' l'attrezo sbloccante: la stanza e' bloccata!");
		}
	
		else {
			buffer.append(super.getDescrizione());
		}
	  return buffer.toString();
	}

}