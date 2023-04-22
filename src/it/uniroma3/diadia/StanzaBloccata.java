package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaBloccata extends Stanza {
	private String attrezzo;
	private String direzioneBloccata;
	
	public StanzaBloccata(String nome, String attrezzo, String direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzo = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
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

//	@Override
//	public String getDescrizione() {
//		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";
//
//		if(!this.hasAttrezzo(attrezzoSbloccante))
//			return bloccata;
//		return super.getDescrizione();
//	}

}