package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	Stanza obj = new Stanza("prova");
	Attrezzo attr = new Attrezzo();
	@Test
	public void testAddAttrezzo() {
		int prova = obj.getNumeroAttrezzi();
		assertEquals(0,prova);
		
		// aggiungo attrezzo per verificare se funziona anche con array non vuoto
		attr.setNome("attrezzo");
		attr.setPeso(3);
		obj.addAttrezzo(attr);
		
		prova = obj.getNumeroAttrezzi();
		assertEquals(1,prova);
	}

	@Test
	public void testHasAttrezzo() {
		boolean prova = obj.hasAttrezzo("attr");
		assertEquals(false,prova);
	}

	@Test
	public void testRemoveAttrezzo() {
		boolean prova = obj.removeAttrezzo(attr);
		assertEquals(false,prova);
		 
		attr.setNome("attrezzo");
		attr.setPeso(3);
		obj.addAttrezzo(attr);
		prova = obj.removeAttrezzo(attr);
		assertEquals(true,prova);
	}

}
