package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
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
		Labirinto lab = new Labirinto();
		partita = new Partita(lab);
		stanzaAd = new Stanza("stanza adiacente");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testEseguiDirezioneInesistente () {
	 partita.getLabirinto().setEntrata(stanza);
	 comando.esegui(partita); 
     assertEquals(stanza, partita.getLabirinto().getEntrata());
	}
	
	@Test
	public void testEseguiDirezioneEsistente () {
	 partita.getLabirinto().setEntrata(stanza);
	 stanza.impostaStanzaAdiacente("sud", stanzaAd);
	 comando.setParametro("sud");
	 comando.esegui(partita);
	 assertEquals(stanzaAd, stanza.getStanzaAdiacente("sud"));
	}
}
