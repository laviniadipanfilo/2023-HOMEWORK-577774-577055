package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Partita obj = new Partita();
	@Test
	public void testGetStanzaVincente() {
		String prova = obj.getStanzaVincente().getNome();
		assertEquals("Biblioteca",prova);
	}
	
	@Test
	public void testVinta() {
       boolean prova = obj.vinta();
       assertEquals(false,prova);
	}

	@Test
	public void testIsFinita() {
	   boolean prova = obj.isFinita();
	   assertEquals(false,prova);
	}

}
