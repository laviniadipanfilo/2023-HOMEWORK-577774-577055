package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	
	private Comando comando;
	private FabbricaDiComandiFisarmonica f;
	
	@Before 
	public void setUp () {
		f = new FabbricaDiComandiFisarmonica();
	}
	
	@Test 
	public void testComandoNonValido () {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), f.costruisciComando("ciao").getNome());
	}
	
	@Test
	public void testComandoConParametro () {
		comando = new ComandoVai("nord");
		Comando crea = f.costruisciComando("vai nord");
		assertEquals(comando.getNome(), crea.getNome());
		assertEquals(comando.getParametro(), crea.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro () {
		comando = new ComandoAiuto();
		assertEquals(comando.getNome(), f.costruisciComando("aiuto").getNome());
	}
}
