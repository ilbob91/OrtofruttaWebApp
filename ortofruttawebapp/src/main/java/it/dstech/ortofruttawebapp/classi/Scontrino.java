package it.dstech.ortofruttawebapp.classi;

import java.util.ArrayList;
import java.util.List;
 
public class Scontrino {
	
	private int idScontrino;
	private String nome;
	private String data; 
	private double spesaTotale;
	
	public Scontrino(int idScontrino, String nome, String data, double spesaTotale) {
		super();
		this.idScontrino = idScontrino;
		this.nome = nome;
		this.data = data;
		this.spesaTotale = spesaTotale;
	}

	public int getIdScontrino() {
		return idScontrino;
	}

	public void setIdScontrino(int idScontrino) {
		this.idScontrino = idScontrino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getSpesaTotale() {
		return spesaTotale;
	}

	public void setSpesaTotale(double spesaTotale) {
		this.spesaTotale = spesaTotale;
	}

	@Override
	public String toString() {
		return "Scontrino [idScontrino=" + idScontrino + ", nome=" + nome + ", data=" + data + ", spesaTotale="
				+ spesaTotale + "]";
	}
	
	
	
	
	
	
	
	
	

}
