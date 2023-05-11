package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	SortedSet<Attrezzo> set;
	List<Attrezzo> lista;
	Set<Attrezzo> set1;
	Map<Integer, Set<Attrezzo>> mappa;
	Borsa b;
	Attrezzo a1;
	Attrezzo a2;
	Attrezzo a3;
	
	@Before
	public void setUp() {
		set = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		lista = new ArrayList<Attrezzo>();
		set1 = new HashSet<>();
		mappa = new HashMap<Integer, Set<Attrezzo>>();
		b = new Borsa();
		a1 = new Attrezzo("martello", 2);
		a2 = new Attrezzo("spada", 2);
		a3 = new Attrezzo("spada", 5);
	}

	@Test
	public void testAddAttrezzo() {
		boolean prova = b.addAttrezzo(a1);
		assertEquals(true,prova);

	}

	@Test
	public void testIsEmpty() {
		boolean prova = b.isEmpty();
		assertEquals(true,prova);
	}

	@Test
	public void testRemoveAttrezzo() {
		b.addAttrezzo(a1);
        Attrezzo prova = b.removeAttrezzo(a1.getNome());
        assertEquals(a1.getNome(),prova.getNome());
        assertEquals(a1.getPeso(),prova.getPeso());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		set.add(a1);
		set.add(a2);
		assertArrayEquals(set.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziDiversiPesoDiverso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a3);
		set.add(a1);
		set.add(a3);
		assertArrayEquals(set.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		lista.add(a1);
		lista.add(a2);
		assertArrayEquals(lista.toArray(), b.getContenutoOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a3);
		lista.add(a1);
		lista.add(a3);
		assertArrayEquals(lista.toArray(), b.getContenutoOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		set.add(a1);
		set.add(a2);
		assertArrayEquals(set.toArray(), b.getContenutoOrdinatoPerNome().toArray());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomePesoDiverso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a3);
		set.add(a1);
		set.add(a3);
		assertArrayEquals(set.toArray(), b.getContenutoOrdinatoPerNome().toArray());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiUguali() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		set1.add(a1);
		set1.add(a2);
		
		mappa.put(a1.getPeso(), set1);
		mappa.put(a2.getPeso(), set1);
		assertEquals(mappa, b.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversi() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a3);
		set.add(a1);
		set1.add(a3);
		mappa.put(a1.getPeso(), set);
		mappa.put(a3.getPeso(), set1);
		assertEquals(mappa, b.getContenutoRaggruppatoPerPeso());
	}
}
