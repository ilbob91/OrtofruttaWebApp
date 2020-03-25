package it.dstech.ortofruttawebapp.classi;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	
	private String nome;
	private int eta;
	private List<Scontrino> listaScontrini;
	
	public Utente(String nome, int eta) {
		super();
		this.nome = nome;
		this.eta = eta;
		this.listaScontrini = new ArrayList<>();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public List<Scontrino> getListaScontrini() {
		return listaScontrini;
	}
	public void setListaScontrini(List<Scontrino> listaScontrini) {
		this.listaScontrini = listaScontrini;
	}


	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", eta=" + eta + ", listaScontrini=" + listaScontrini + "]";
	}
	
	
	
}
