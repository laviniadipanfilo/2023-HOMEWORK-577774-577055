package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	Stanza s1;
	Stanza s2;
	Attrezzo attr = new Attrezzo();
	
	@Before
	public void setUp() {
		s1 = new Stanza("ds2");
		s2 = new Stanza("atrio");
	}
	
	@Test
	public void testAddAttrezzo() {
		int prova = s1.getNumeroAttrezzi();
		assertEquals(0,prova);
		
		// aggiungo attrezzo per verificare se funziona anche con array non vuoto
		attr.setNome("attrezzo");
		attr.setPeso(3);
		s1.addAttrezzo(attr);
		
		prova = s1.getNumeroAttrezzi();
		assertEquals(1,prova);
	}

	@Test
	public void testHasAttrezzo() {
		boolean prova = s1.hasAttrezzo("attr");
		assertEquals(false,prova);
	}

	@Test
	public void testRemoveAttrezzo() {
		boolean prova = s1.removeAttrezzo(attr);
		assertEquals(false,prova);
		 
		attr.setNome("attrezzo");
		attr.setPeso(3);
		s1.addAttrezzo(attr);
		prova = s1.removeAttrezzo(attr);
		assertEquals(true,prova);
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("est", s2);
		assertEquals(s2, s1.getStanzaAdiacente("est"));
	}
}
