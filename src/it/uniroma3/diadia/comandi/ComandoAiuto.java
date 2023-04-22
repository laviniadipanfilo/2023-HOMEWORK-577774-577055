package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO io = new IOConsole();
	private static final String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
	 for(int i=0; i< elencoComandi.length; i++) 
	  io.mostraMessaggio(elencoComandi[i]+" ");
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
