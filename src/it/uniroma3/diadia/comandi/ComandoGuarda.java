package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private String parametro;
	private IO io = new IOConsole();
	 private static final String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
		io.mostraMessaggio("CFU:" + partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		return this.NOME;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}
  
}
