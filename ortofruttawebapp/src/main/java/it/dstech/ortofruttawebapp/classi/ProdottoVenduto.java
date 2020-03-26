package it.dstech.ortofruttawebapp.classi;

public class ProdottoVenduto {
	
	private String nomeCliente;
	private String nomeProdotto; 
	private int quantitaVenduta;
	private double prezzo;
	
	public ProdottoVenduto(String nomeProdotto, int quantitaVenduta) {
		super();
		this.nomeProdotto = nomeProdotto;
		this.quantitaVenduta = quantitaVenduta;
	
	}
	
	
	
	public ProdottoVenduto(String nomeCliente, String nomeProdotto, int quantitaVenduta) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomeProdotto = nomeProdotto;
		this.quantitaVenduta = quantitaVenduta;
	}



	public ProdottoVenduto(String nomeCliente, String nomeProdotto, int quantitaVenduta, double prezzo) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomeProdotto = nomeProdotto;
		this.quantitaVenduta = quantitaVenduta;
		this.prezzo = prezzo;
	
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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



	@Override
	public String toString() {
		return "ProdottoVenduto [nomeCliente=" + nomeCliente + ", nomeProdotto=" + nomeProdotto + ", quantitaVenduta="
				+ quantitaVenduta + ", prezzo=" + prezzo + "]";
	}





	
	
}
