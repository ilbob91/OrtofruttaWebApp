package it.dstech.ortofruttawebapp.classi;

public class ProdottoVenduto {
	
	private String nomeCliente;
	private String nomeProdotto; 
	private int quantitaVenduta;
	
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
				+ quantitaVenduta + "]";
	}

	
	
}
