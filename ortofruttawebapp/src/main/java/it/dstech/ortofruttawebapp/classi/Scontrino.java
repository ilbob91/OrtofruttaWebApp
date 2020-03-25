package it.dstech.ortofruttawebapp.classi;

import java.util.ArrayList;
import java.util.List;
 
public class Scontrino {
	
	private int idUtente;
	private String data; 
	private double spesaTotale;
	private List<ProdottoVenduto> listaProdotto;
	
	
	
	public Scontrino(int idUtente, String data, double spesaTotale) {
		super();
		this.idUtente = idUtente;
		this.data = data;
		this.spesaTotale = spesaTotale;
		this.listaProdotto = new ArrayList<>();
	}
	
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
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
		return "Scontrino [idUtente=" + idUtente + ", data=" + data + ", spesaTotale=" + spesaTotale
				+ ", listaProdotto=" + listaProdotto + "]";
	}
	
	
	
	

}
