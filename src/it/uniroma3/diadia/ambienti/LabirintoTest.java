package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	Labirinto lab = new Labirinto();
	Stanza prova;
	
	@Test
	public void testGetEntrata() {
		prova = lab.getEntrata();
		assertEquals("Atrio", prova.getNome());
	}

	@Test
	public void testGetUscita() {
		prova = lab.getUscita();
		assertEquals("Biblioteca", prova.getNome());
	}

}
