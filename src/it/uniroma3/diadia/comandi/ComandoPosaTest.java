package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	
	private ComandoPosa comando;
	private Partita partita;
	private Attrezzo attrezzo;
	private Borsa borsa;

	@Before
	public void setUp() throws Exception {
		comando = new ComandoPosa("sasso");
		partita = new Partita();
		attrezzo = new Attrezzo("sasso",2);
		borsa = new Borsa();
	}

	@Test
	public void testEseguiAttrezzoEsistente () {
     partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
     comando.esegui(partita);
     assertEquals(borsa.getNumeroAttrezzi(), 0);
	}
	
	@Test
	public void testEseguiAttrezzoNonEsistente () {
	 comando.esegui(partita);
	 assertEquals(borsa.getNumeroAttrezzi(), 0);
	}
	

}
