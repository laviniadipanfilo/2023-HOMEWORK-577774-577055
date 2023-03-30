package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
    Giocatore gioc = new Giocatore();
    Borsa borsa = new Borsa();
    
	
	@Test
	public void testGetBorsa() {
        Borsa prova = gioc.getBorsa();
        assertNotNull(prova);
	}

	@Test
	public void testGetCfu() {
		int prova = gioc.getCfu();
		assertEquals(20,prova);
	}

	@Test
	public void testSetCfu() {
        int prova = gioc.getCfu();
        gioc.setCfu(prova--);
		assertEquals(19,prova);
	}

}
