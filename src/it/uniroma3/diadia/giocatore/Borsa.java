package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
	  this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
	 this.pesoMax = pesoMax;
	 this.attrezzi = new Attrezzo[10]; // speriamo bastino...
	 this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
	  if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
	   return false;
	  if (this.numeroAttrezzi==10)
	   return false;
	 this.attrezzi[this.numeroAttrezzi] = attrezzo;
	 this.numeroAttrezzi++;
	return true;
	}
	
	 public String getDescrizione() {
	        return this.toString();
	    }
	
	public int getPesoMax() {
	 return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	 Attrezzo a = null;
	  for (int i= 0; i<this.numeroAttrezzi; i++)
	   if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
	  a = attrezzi[i];
	return a;
	}
	
	 public int getNumeroAttrezzi () {
			return this.numeroAttrezzi;
		}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
		  peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	public boolean isEmpty() {
	    return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = new Attrezzo(); // a => elemento che tolgo dalla borsa e metto nella stanza
		// ---> TODO <---
		int indice = 0;
		int i = 0;
		for(i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				indice = i;
			
			    a.setNome(this.attrezzi[i].getNome());
			    a.setPeso(this.attrezzi[i].getPeso());
			    
			}
		}
		
		// se elimino l'ultimo elemento
		if(indice == this.attrezzi.length-1) {
			this.numeroAttrezzi--;
		}
		
		else {
		for(i=indice; i<this.numeroAttrezzi; i++) {
			   for(int j=i+1; j<this.numeroAttrezzi; j++) {
				   i = j-1;
				   this.attrezzi[i] = this.attrezzi[j];
			   }
			}
		this.numeroAttrezzi--;
		}
		
	  return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

	  if (!this.isEmpty()) {
	  s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
	  
		for (int i= 0; i<this.numeroAttrezzi; i++)
		s.append(attrezzi[i].toString()+" ");
	  }
	  else
		s.append("Borsa vuota");
	   return s.toString();
	}
}
