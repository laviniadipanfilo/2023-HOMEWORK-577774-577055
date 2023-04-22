package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private IO io = new IOConsole();
	 private static final String NOME = "fine";
	
	@Override
	public void esegui(Partita partita) {
	   io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	   System.exit(1);
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
		return null;
	}
}
