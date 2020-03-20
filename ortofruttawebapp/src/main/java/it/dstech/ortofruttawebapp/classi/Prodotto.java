package it.dstech.ortofruttawebapp.classi;

public class Prodotto {
private String nomeProdotto; 
private int quantitaResidua;
private double prezzo;
private String descrizione;


public Prodotto(String nomeProdotto, int quantitaResidua, double prezzo, String descrizione) {
	super();
	this.nomeProdotto = nomeProdotto;
	this.quantitaResidua = quantitaResidua;
	this.prezzo = prezzo;
	this.descrizione = descrizione;
}
@Override
public String toString() {
	return "Prodotto [nomeProdotto=" + nomeProdotto + ", quantitaResidua=" + quantitaResidua + ", prezzo=" + prezzo
			+ ", descrizione=" + descrizione + "]";
}
public String getNomeProdotto() {
	return nomeProdotto;
}
public void setNomeProdotto(String nomeProdotto) {
	this.nomeProdotto = nomeProdotto;
}
public int getQuantitaResidua() {
	return quantitaResidua;
}
public void setQuantitaResidua(int quantitaResidua) {
	this.quantitaResidua = quantitaResidua;
}
public double getPrezzo() {
	return prezzo;
}
public void setPrezzo(double prezzo) {
	this.prezzo = prezzo;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}




}
