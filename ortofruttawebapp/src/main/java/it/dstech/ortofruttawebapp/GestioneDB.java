package it.dstech.ortofruttawebapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import it.dstech.ortofruttawebapp.classi.Prodotto;
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;
import it.dstech.ortofruttawebapp.classi.Scontrino;

public class GestioneDB {

	private Connection connessione;

	public GestioneDB() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "MIGNKbTWv0";
		String username = "rMIwGtutXd";
		String url = "jdbc:mysql://remotemysql.com:3306/rMIwGtutXd?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		this.connessione = DriverManager.getConnection(url, username, password);
	}
	
	public void close() throws SQLException {
		this.connessione.close();
	}

	public List<ProdottoVenduto> updateQuantitaVendute(String name, int q) throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {

				int sottrazione = elenco.get(i).getQuantitaResidua() - q;
				elenco.get(i).setQuantitaResidua(sottrazione);
				updateTabellaProdotti(name, sottrazione);
				inserimentoTabellaVendita(name, q);
				ResultSet risultatoQuery2 = stampaListaVenduto();
				List<ProdottoVenduto> listaProdottiVenduti = new ArrayList<>();
				while (risultatoQuery2.next()) {
					String nome = risultatoQuery2.getString("nomeProdotto");
					int quantita = risultatoQuery2.getInt("quantitaVenduta");

					ProdottoVenduto prodotto = new ProdottoVenduto(nome, quantita);
					listaProdottiVenduti.add(prodotto);
				}
				return listaProdottiVenduti;

			}

		}
		return null;
	}

	public void updateQuantitaAggiuntaAlCarrello(String nomeProdotto, int q)
			throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(nomeProdotto)) {

				int sottrazione = elenco.get(i).getQuantitaResidua() - q;
				elenco.get(i).setQuantitaResidua(sottrazione);
				updateTabellaProdotti(nomeProdotto, sottrazione);

			} // inserimentoTabellaAcquisto(connessione, name, nomeProdotto, q);
		}
	}

	public boolean checkVendita(List<Prodotto> elenco, String nomeProdotto, int q) throws ClassNotFoundException, SQLException {
		for (Prodotto p : elenco) {
			if (nomeProdotto.equalsIgnoreCase(p.getNomeProdotto()) && q > p.getQuantitaResidua()) {
				return false;
			}
		}
		
		return true;
	}

	public List<Prodotto> stampaProdotti() throws SQLException {
		PreparedStatement state = connessione.prepareStatement("select * from prodotto");

		ResultSet risultatoQuery = state.executeQuery();
		List<Prodotto> elenco = new ArrayList<>();
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("nomeProdotto");
			int quantita = risultatoQuery.getInt("quantitaResidua");
			double prezzo = risultatoQuery.getDouble("prezzo");
			String descrizione = risultatoQuery.getString("descrizione");

			Prodotto prodotto = new Prodotto(nome, quantita, prezzo, descrizione);
			elenco.add(prodotto);

		}

		return elenco;
	}

	public ResultSet stampaListaVenduto() throws SQLException {
		PreparedStatement statement2 = connessione.prepareStatement("select * from vendita");

		ResultSet risultatoQuery2 = statement2.executeQuery();

		return risultatoQuery2;
	}

	public ResultSet stampaListaAcquisti() throws SQLException {
		PreparedStatement statement2 = connessione.prepareStatement("select * from acquisto");

		ResultSet risultatoQuery2 = statement2.executeQuery();

		return risultatoQuery2;
	}

	public void inserimentoTabellaVendita(String name, int q) throws SQLException {
		PreparedStatement statement1 = connessione
				.prepareStatement("insert into vendita (nomeProdotto, quantitaVenduta) values (?,?);");
		statement1.setString(1, name);
		statement1.setInt(2, q);
		statement1.execute();
	}

	public void inserimentoTabellaAcquisto(String name, String nomeProdotto, int q, int idScontrino)
			throws SQLException {
		PreparedStatement statement1 = connessione.prepareStatement(
				"insert into acquisto (nome, nomeProdotto, quantitaAcquistata, idScontrino) values (?,?,?,?);");
		statement1.setString(1, name);
		statement1.setString(2, nomeProdotto);
		statement1.setInt(3, q);
		statement1.setInt(4, idScontrino);
		statement1.execute();
	}

	public void updateTabellaProdotti(String name, int sottrazione) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update prodotto set quantitaResidua = ? where nomeProdotto = ?;");
		statement.setString(2, name);
		statement.setInt(1, sottrazione);
		statement.execute();
	}

	public List<Prodotto> getListaProdottiDopoRimozione(String name) throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti();

		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {

				removeProdotti(name);
				elenco.remove(i);
				return elenco;
			}

		}
	
		return null;
	}

	public void removeProdotti(String name) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("delete from prodotto where nomeProdotto = ?;");
		statement.setString(1, name);
		statement.execute();
	}

	public List<Prodotto> getProdotti(Prodotto p) throws SQLException, ClassNotFoundException {
		inserisciProdotti(p);
		List<Prodotto> elenco = stampaProdotti();
		
		return elenco;

	}

	public void inserisciProdotti(Prodotto p) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement(
				"insert into prodotto (nomeProdotto, quantitaResidua, prezzo, descrizione) values (?,?,?,?);");
		statement.setString(1, p.getNomeProdotto());
		statement.setInt(2, p.getQuantitaResidua());
		statement.setDouble(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
		statement.execute();
	}

	public List<ProdottoVenduto> stampaVenduto() throws SQLException, ClassNotFoundException {

		List<ProdottoVenduto> elenco = new ArrayList<>();
		ResultSet risultato = stampaListaVenduto();
		while (risultato.next()) {
			String nome = risultato.getString(1);
			int quantita = risultato.getInt(2);
			ProdottoVenduto p = new ProdottoVenduto(nome, quantita);
			elenco.add(p);

		}

		return elenco;
	}

	public List<Prodotto> updateQuantita(String name, int q) throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti();

		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {
				int somma = elenco.get(i).getQuantitaResidua() + q;
				elenco.get(i).setQuantitaResidua(somma);
				updateProdotti(name, somma);
				return elenco;
			}
		}
	
		return null;
	}

	public void updateProdotti(String name, int somma) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update prodotto set quantitaResidua = ? where nomeProdotto = ?;");
		statement.setString(2, name);
		statement.setInt(1, somma);
		statement.execute();
	}

	public boolean isUtente(String nome) throws SQLException {
		PreparedStatement s = connessione.prepareStatement("select * from utente where nome = ?;");
		s.setString(1, nome);
		ResultSet risultato = s.executeQuery();
		while (risultato.next()) {

			return true;
		}

		return false;
	}

	public void checkUtente(String nome, int eta) throws SQLException {
		if (isUtente(nome)) {
			updateUtente(nome, eta);
		} else {
			insertUtente(nome, eta);

		}
	}

	public void updateUtente(String nome, int eta) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("update utente set eta =? where nome = ?;");

		statement.setInt(1, eta);
		statement.setString(2, nome);
		statement.execute();

	}

	public void insertUtente(String nome, int eta) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("insert into utente (nome, eta) values (?,?);");
		statement.setString(1, nome);
		statement.setInt(2, eta);
		statement.execute();

	}

	public  double getPrezzo( int idScontrino) throws SQLException {
		double costo = 0;
		String query = "select acquisto.quantitaAcquistata,prodotto.prezzo from acquisto inner join prodotto on acquisto.nomeProdotto=prodotto.nomeProdotto where acquisto.idScontrino=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idScontrino);

		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			costo = costo + (risultato.getInt(1) * risultato.getDouble(2));

		}
		return costo;

	}

	public  boolean spesaTotaleScontrino( int idScontrino, double costo)
			throws ClassNotFoundException, SQLException {

		String query = "update scontrino set spesa=? where idScontrino=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setDouble(1, costo);
		statement.setInt(2, idScontrino);
		statement.execute();
		return true;

	}

	public  int creaScontrino(String nome) throws SQLException {

		PreparedStatement state = connessione
				.prepareStatement("insert into scontrino (idScontrino, data, nome) values (?,?,?);");
		java.util.Date data = new java.util.Date();
		DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		int idScontrino = (int) (Math.random() * 1000 + Math.random() * 1000);
		state.setInt(1, idScontrino);
		state.setString(2, formato.format(data));
		state.setString(3, nome);
		state.execute();
		return idScontrino;
	}

	public  List<Scontrino> stampaScontrini(String nome) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("select * from scontrino where nome = ?;");
		statement.setString(1, nome);

		ResultSet risultatoQuery = statement.executeQuery();
		List<Scontrino> elenco = new ArrayList<>();
		while (risultatoQuery.next()) {
			int idScontrino = risultatoQuery.getInt("idScontrino");
			String data = risultatoQuery.getString("data");
			double spesa = risultatoQuery.getDouble("spesa");

			Scontrino scontrino = new Scontrino(idScontrino, nome, data, spesa);
			elenco.add(scontrino);

		}

		return elenco;

	}

	public  List<ProdottoVenduto> stampaProdottiScontrino(int idScontrino)
			throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("select nome, nomeProdotto, quantitaAcquistata from acquisto where idScontrino = ?;");
		statement.setInt(1, idScontrino);

		ResultSet risultatoQuery = statement.executeQuery();
		List<ProdottoVenduto> elenco = new ArrayList<>();
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("nome");
			String nomeProdotto = risultatoQuery.getString("nomeProdotto");
			int quantita = risultatoQuery.getInt("quantitaAcquistata");

			ProdottoVenduto p = new ProdottoVenduto(idScontrino, nome, nomeProdotto, quantita);
			elenco.add(p);

		}

		return elenco;

	}
}
