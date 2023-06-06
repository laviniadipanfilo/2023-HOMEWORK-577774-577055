package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	Partita p;
	Labirinto labirinto;
	Stanza s;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getUscita().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setEntrata(s);
		assertEquals(s, p.getLabirinto().getEntrata());
	}

	@Test
	public void testIsFinita() {
		assertFalse(p.isFinita());
	}

}
