package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Partita obj;
	Labirinto lab;
	
	@Before
	public void setUp() {
		lab = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addAttrezzo("martello", 3)
				.addAttrezzo("roccia", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne", "Biblioteca", "ovest")
				.getLabirinto();
		obj = new Partita(lab);
	}
	
	@Test
	public void testGetStanzaVincente() {
		String prova = obj.getStanzaVincente().getNome();
		assertEquals("Biblioteca",prova);
	}
	
	@Test
	public void testVinta() {
       boolean prova = obj.vinta();
       assertEquals(false,prova);
	}

	@Test
	public void testIsFinita() {
	   boolean prova = obj.isFinita();
	   assertEquals(false,prova);
	}

}
