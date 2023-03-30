package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa borsa = new Borsa();
	Attrezzo attr = new Attrezzo();

	@Test
	public void testAddAttrezzo() {
		boolean prova = borsa.addAttrezzo(attr);
		assertEquals(true,prova);

	}

	@Test
	public void testIsEmpty() {
		boolean prova = borsa.isEmpty();
		assertEquals(true,prova);
	}

	@Test
	public void testRemoveAttrezzo() {
        Attrezzo prova = borsa.removeAttrezzo(attr.getNome());
        assertEquals(attr.getNome(),prova.getNome());
        assertEquals(attr.getPeso(),prova.getPeso());
	}

}
