package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
	  this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {	
	 this.pesoMax = pesoMax;
	 this.numeroAttrezzi = 0;
	 this.attrezzi = new HashMap<String,Attrezzo>();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(! this.hasAttrezzo(attrezzo.getNome())) {
	        this.attrezzi.put(attrezzo.getNome(), attrezzo); 
			this.numeroAttrezzi++;
			return true;
		}
	 return false;
	}
	 
	 public String getDescrizione() {
		    StringBuilder s = new StringBuilder();
	    	
	    	for(Attrezzo i : this.attrezzi.values()) {
	    		s.append(i.toString());
	    	}
	    return this.toString();
	  }
	
	public int getPesoMax() {
	 return pesoMax;
	}
	
	public Attrezzo getAttrezzo (String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public int getNumeroAttrezzi () {
			return this.numeroAttrezzi;
		}
	
	public int getPeso() {
		int peso = 0;
		for(Attrezzo i : this.attrezzi.values()) {
			peso = peso + i.getPeso();
		}
	 return peso;
	}
	
	public boolean isEmpty() {
	    return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo (String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo removeAttrezzo (String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo)) {
			this.numeroAttrezzi--;
			return this.attrezzi.remove(nomeAttrezzo);
		}
	 return null;
    }
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoOrdinatoPerNome().toString() + "\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString() + "\n");
			s.append("[");
			for(int i=0; i<this.numeroAttrezzi; i++) {
				if(i == this.numeroAttrezzi-1) 
					s.append(this.getContenutoOrdinatoPerPeso().get(i).getNome());
				else 
					s.append(this.getContenutoOrdinatoPerPeso().get(i).getNome() + ", ");
			}
			s.append("]\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}

	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>();

		for(Attrezzo a : this.attrezzi.values()){
			if(a2p.containsKey(a.getPeso())) {
				a2p.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s =new HashSet<Attrezzo>();
				s.add(a);
				a2p.put(a.getPeso(), s);
			}
		}
		return a2p;
	}

	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}

}
