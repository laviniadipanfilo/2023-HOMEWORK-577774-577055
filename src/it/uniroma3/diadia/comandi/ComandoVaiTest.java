package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Partita partita;
	private ComandoVai comando;
	private Stanza stanza;
	private Stanza stanzaAd;
	
	@Before
	public void setUp() throws Exception {
		comando = new ComandoVai("sud");
		stanza = new Stanza("stanza");
		partita = new Partita();
		stanzaAd = new Stanza("stanza adiacente");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testEseguiDirezioneInesistente () {
	 partita.setStanzaCorrente(stanza);
	 comando.esegui(partita); 
     assertEquals(stanza, partita.getStanzaCorrente());
	}
	
	@Test
	public void testEseguiDirezioneEsistente () {
	 partita.setStanzaCorrente(stanza);
	 stanza.impostaStanzaAdiacente("sud", stanzaAd);
	 comando.setParametro("sud");
	 comando.esegui(partita);
	 assertEquals(stanzaAd, stanza.getStanzaAdiacente("sud"));
	}
}
