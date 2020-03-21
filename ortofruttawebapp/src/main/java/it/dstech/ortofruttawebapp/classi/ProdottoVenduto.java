package it.dstech.ortofruttawebapp.classi;

public class ProdottoVenduto {

	private String nomeProdotto; 
	private int quantitaVenduta;
	
	public ProdottoVenduto(String nomeProdotto, int quantitaVenduta) {
		super();
		this.nomeProdotto = nomeProdotto;
		this.quantitaVenduta = quantitaVenduta;
	}
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	public int getQuantitaVenduta() {
		return quantitaVenduta;
	}
	public void setQuantitaVenduta(int quantitaVenduta) {
		this.quantitaVenduta = quantitaVenduta;
	}
	
	
}
