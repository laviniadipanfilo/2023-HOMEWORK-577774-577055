package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("StanzaBloccata", "martello", "ovest");
		stanza = new Stanza("stanza");
		attrezzo = new Attrezzo("martello", 3);
		stanzaBloccata.impostaStanzaAdiacente("ovest", stanza);
	}
	
	@Test 
	public void testGetStanzaAdiacente () {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata () {
		stanzaBloccata.addAttrezzo(attrezzo);
		assertEquals(stanza, stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test 
	public void testGetDescrizioneDirezioneSbloccata () {
		stanzaBloccata.addAttrezzo(attrezzo);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}
	
    @Test 
    public void testGetDescrizioneDirezioneBloccata () {
    	assertEquals("nella stanza non c'e' l'attrezo sbloccante: la stanza e' bloccata!", stanzaBloccata.getDescrizione());
    }
}
