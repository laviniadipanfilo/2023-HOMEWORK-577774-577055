package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	Stanza s;
	Attrezzo a1;
	Attrezzo a2;
	Attrezzo a3;
	

	@Before
	public void setUp() throws Exception {
		s = new Stanza("biblioteca");
		a1 = new Attrezzo("sasso",1);
		a2 = new Attrezzo("lanterna",3);
		a3 = new Attrezzo("spada",5);
	}

	@Test
	public void testAddAttrezzo() {
		assertEquals(0, s.getNumeroAttrezzi());
		s.addAttrezzo(a1);
		assertEquals(1, s.getNumeroAttrezzi());
	}
	
	@Test 
	public void testModificaAttrezzo() {
		assertTrue(s.addAttrezzo(a1));
		assertTrue(s.addAttrezzo(a2));
		assertTrue(s.addAttrezzo(a3));
	}

}
