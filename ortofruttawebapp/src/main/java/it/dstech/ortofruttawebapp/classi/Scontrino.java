package it.dstech.ortofruttawebapp.classi;

import java.util.ArrayList;
import java.util.List;
 
public class Scontrino {
	
	private String nome;
	private String data; 
	private double spesaTotale;
	private List<ProdottoVenduto> listaProdotto;
	
	
	
	public Scontrino(String nome, String data, double spesaTotale) {
		super();
		this.nome = nome;
		this.data = data;
		this.spesaTotale = spesaTotale;
		this.listaProdotto = new ArrayList<>();
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
	public List<ProdottoVenduto> getListaProdotto() {
		return listaProdotto;
	}
	public void setListaProdotto(List<ProdottoVenduto> listaProdotto) {
		this.listaProdotto = listaProdotto;
	}


	@Override
	public String toString() {
		return "Scontrino [idUtente=" + nome + ", data=" + data + ", spesaTotale=" + spesaTotale
				+ ", listaProdotto=" + listaProdotto + "]";
	}
	
	
	
	

}
