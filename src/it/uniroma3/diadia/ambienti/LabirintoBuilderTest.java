package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	
	LabirintoBuilder lb;

	@Before
	public void setUp() throws Exception {
		lb = new LabirintoBuilder();
	}

	@Test
	public void testAddStanza() {
		lb.addStanza("Atrio");
		Stanza s = new Stanza("Atrio");
		assertEquals(s.getNome(), lb.getUltimaStanzaAggiunta().getNome());
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("sasso", 1).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta() {
		lb.addStanza("biblioteca");
		lb.addAttrezzo("lanterna", 3);
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("sasso", 1).getClass());
	}
}
