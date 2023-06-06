package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "martello",  Direzione.ovest);
		s = new Stanza("Atrio");
		a = new Attrezzo("martello", 1);
		sb.impostaStanzaAdiacente(Direzione.ovest, s);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente(Direzione.ovest));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente(Direzione.ovest));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "nella stanza non c'e' l'attrezo sbloccante: la stanza e' bloccata!";
		assertEquals(e, sb.getDescrizione());
		
	}

}
