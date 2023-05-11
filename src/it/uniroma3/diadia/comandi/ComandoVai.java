package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	  private String direzione;
	  private IO io = new IOConsole();
	  private static final String NOME = "vai";
	  
	  public ComandoVai(String direzione) {
	      this.direzione = direzione;
	  }
	  
	  @Override
	  public void esegui(Partita partita) {
			Stanza stanzaCorrente=partita.getLabirinto().getEntrata();
			Stanza prossimaStanza=null;
			if(this.direzione==null) {
				this.io.mostraMessaggio("Dove vuoi andare? Devi specificare la direzione");
				return; 
			}
			prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
			if(prossimaStanza==null) {
				this.io.mostraMessaggio("Direzione inesistente");
				return;
			}
			partita.getLabirinto().setEntrata(prossimaStanza);
			this.io.mostraMessaggio(partita.getLabirinto().getEntrata().getNome());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		} 
	  
	@Override
	public void setParametro (String parametro) {
		this.direzione = parametro;
	}
	  
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
	  
	  
}
