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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nomeProdotto == null) ? 0 : nomeProdotto.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Prodotto other = (Prodotto) obj;
	if (nomeProdotto == null) {
		if (other.nomeProdotto != null)
			return false;
	} else if (!nomeProdotto.equals(other.nomeProdotto))
		return false;
	return true;
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
