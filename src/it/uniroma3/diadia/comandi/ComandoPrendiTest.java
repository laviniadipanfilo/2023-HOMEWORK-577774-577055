package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private ComandoPrendi comando;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private Labirinto lab;
	

	@Before
	public void setUp() throws Exception {
		comando = new ComandoPrendi("sasso");
		lab = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addAttrezzo("martello", 3)
				.addAttrezzo("roccia", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne", "Biblioteca", "ovest")
				.getLabirinto();
		partita = new Partita(lab);
		stanza = new Stanza("stanza");
		attrezzo = new Attrezzo("sasso",3);
	}

	@Test
	public void testEseguiAttrezzoEsistente () {
     partita.getLabirinto().getEntrata().addAttrezzo(attrezzo);
     comando.esegui(partita);
     assertEquals(stanza.getNumeroAttrezzi(),0);
	}
	
	@Test
	public void testEseguiAttrezzoNonEsistente () {
	 comando.esegui(partita);
	 assertEquals(stanza.getNumeroAttrezzi(), 0);
	}
}
