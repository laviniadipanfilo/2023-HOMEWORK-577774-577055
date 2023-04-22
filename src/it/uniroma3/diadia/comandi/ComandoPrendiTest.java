package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private ComandoPrendi comando;
	private Stanza stanza;
	private Attrezzo attrezzo;
	

	@Before
	public void setUp() throws Exception {
		comando = new ComandoPrendi("sasso");
		partita = new Partita();
		stanza = new Stanza("stanza");
		attrezzo = new Attrezzo("sasso",3);
	}

	@Test
	public void testEseguiAttrezzoEsistente () {
     partita.getStanzaCorrente().addAttrezzo(attrezzo);
     comando.esegui(partita);
     assertEquals(stanza.getNumeroAttrezzi(),0);
	}
	
	@Test
	public void testEseguiAttrezzoNonEsistente () {
	 comando.esegui(partita);
	 assertEquals(stanza.getNumeroAttrezzi(), 0);
	}
}
