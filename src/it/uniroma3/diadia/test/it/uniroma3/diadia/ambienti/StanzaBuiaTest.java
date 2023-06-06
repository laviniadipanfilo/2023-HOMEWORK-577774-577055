package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia sb;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		a=new Attrezzo("martello",2);
		sb=new StanzaBuia("Stanza Buia","martello");		
		
	}

	@Test
	public void testGetDescrizioneStanzaConAttrezzo() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneStanzaBuia () {
		assertEquals("qui c'e' un buio pesto", sb.getDescrizione());
	}
}
