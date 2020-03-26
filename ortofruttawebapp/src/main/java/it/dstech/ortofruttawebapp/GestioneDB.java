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
import it.dstech.ortofruttawebapp.classi.Utente;

public class GestioneDB {
	public static Connection connessione() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "MIGNKbTWv0";
		String username = "rMIwGtutXd";
		String url = "jdbc:mysql://remotemysql.com/rMIwGtutXd?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		return connessione;
	}

	public static List<ProdottoVenduto> updateQuantitaVendute(Connection connessione, String name, int q)
			throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti(connessione);
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {

				int sottrazione = elenco.get(i).getQuantitaResidua() - q;
				elenco.get(i).setQuantitaResidua(sottrazione);
				updateTabellaProdotti(connessione, name, sottrazione);
				inserimentoTabellaVendita(connessione, name, q);
				ResultSet risultatoQuery2 = stampaListaVenduto(connessione);
				List<ProdottoVenduto> listaProdottiVenduti = new ArrayList<>();
				while (risultatoQuery2.next()) {
					String nome = risultatoQuery2.getString("nomeProdotto");
					int quantita = risultatoQuery2.getInt("quantitaVenduta");

					ProdottoVenduto prodotto = new ProdottoVenduto(nome, quantita);
					listaProdottiVenduti.add(prodotto);
				}
				connessione.close();
				return listaProdottiVenduti;

			}

		}
		return null;
	}

	public static void updateQuantitaAggiuntaAlCarrello(Connection connessione, String nomeProdotto, int q)
			throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti(connessione);
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(nomeProdotto)) {

				int sottrazione = elenco.get(i).getQuantitaResidua() - q;
				elenco.get(i).setQuantitaResidua(sottrazione);
				updateTabellaProdotti(connessione, nomeProdotto, sottrazione);
				
			}//inserimentoTabellaAcquisto(connessione, name, nomeProdotto, q);
		}
	}

	
	

	public static boolean checkVendita(List<Prodotto> elenco, int q) {

		for (int i = 0; i < elenco.size(); i++) {

			if (q > elenco.get(i).getQuantitaResidua()) {

				return false;

			}

		}
		return true;
	}

	public static List<Prodotto> stampaProdotti(Connection connessione) throws SQLException {
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

	public static ResultSet stampaListaVenduto(Connection connessione) throws SQLException {
		PreparedStatement statement2 = connessione.prepareStatement("select * from vendita");

		ResultSet risultatoQuery2 = statement2.executeQuery();

		return risultatoQuery2;
	}
	
	public static ResultSet stampaListaAcquisti(Connection connessione) throws SQLException {
		PreparedStatement statement2 = connessione.prepareStatement("select * from acquisto");

		ResultSet risultatoQuery2 = statement2.executeQuery();

		return risultatoQuery2;
	}

	public static void inserimentoTabellaVendita(Connection connessione, String name, int q) throws SQLException {
		PreparedStatement statement1 = connessione
				.prepareStatement("insert into vendita (nomeProdotto, quantitaVenduta) values (?,?);");
		statement1.setString(1, name);
		statement1.setInt(2, q);
		statement1.execute();
	}

	public static void inserimentoTabellaAcquisto(Connection connessione, String name, String nomeProdotto, int q)
			throws SQLException {
		PreparedStatement statement1 = connessione
				.prepareStatement("insert into acquisto (nome, nomeProdotto, quantitaAcquistata) values (?,?,?);");
		statement1.setString(1, name);
		statement1.setString(2, nomeProdotto);
		statement1.setInt(3, q);
		statement1.execute();
	}

	public static void updateTabellaProdotti(Connection connessione, String name, int sottrazione) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update prodotto set quantitaResidua = ? where nomeProdotto = ?;");
		statement.setString(2, name);
		statement.setInt(1, sottrazione);
		statement.execute();
	}

	public static List<Prodotto> getListaProdottiDopoRimozione(Connection connessione, String name)
			throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti(connessione);

		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {

				removeProdotti(connessione, name);
				elenco.remove(i);
				return elenco;
			}

		}
		connessione.close();
		return null;
	}

	public static void removeProdotti(Connection connessione, String name) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("delete from prodotto where nomeProdotto = ?;");
		statement.setString(1, name);
		statement.execute();
	}

	public static List<Prodotto> getProdotti(Prodotto p, Connection connessione)
			throws SQLException, ClassNotFoundException {
		inserisciProdotti(p, connessione);
		List<Prodotto> elenco = stampaProdotti(connessione);
		connessione.close();
		return elenco;

	}

	public static void inserisciProdotti(Prodotto p, Connection connessione) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement(
				"insert into prodotto (nomeProdotto, quantitaResidua, prezzo, descrizione) values (?,?,?,?);");
		statement.setString(1, p.getNomeProdotto());
		statement.setInt(2, p.getQuantitaResidua());
		statement.setDouble(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
		statement.execute();
	}

	public static List<ProdottoVenduto> stampaVenduto(Connection connessione)
			throws SQLException, ClassNotFoundException {

		List<ProdottoVenduto> elenco = new ArrayList<>();
		ResultSet risultato = stampaListaVenduto(connessione);
		while (risultato.next()) {
			String nome = risultato.getString(1);
			int quantita = risultato.getInt(2);
			ProdottoVenduto p = new ProdottoVenduto(nome, quantita);
			elenco.add(p);

		}

		return elenco;
	}

	public static List<Prodotto> updateQuantita(Connection connessione, String name, int q)
			throws SQLException, ClassNotFoundException {

		List<Prodotto> elenco = stampaProdotti(connessione);

		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getNomeProdotto().equals(name)) {
				int somma = elenco.get(i).getQuantitaResidua() + q;
				elenco.get(i).setQuantitaResidua(somma);
				updateProdotti(connessione, name, somma);
				return elenco;
			}
		}
		connessione.close();
		return null;
	}

	public static void updateProdotti(Connection connessione, String name, int somma) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update prodotto set quantitaResidua = ? where nomeProdotto = ?;");
		statement.setString(2, name);
		statement.setInt(1, somma);
		statement.execute();
	}

	public static boolean isUtente(Connection connessione, String nome) throws SQLException {
		PreparedStatement s = connessione.prepareStatement("select * from utente where nome = ?;");
		s.setString(1, nome);
		ResultSet risultato = s.executeQuery();
		while (risultato.next()) {

			return true;
		}
		
		return false;
	}

	public static void checkUtente(Connection connessione, String nome, int eta) throws SQLException {
		if (isUtente(connessione, nome)) {
			updateUtente(connessione, nome, eta);
		} else {
			insertUtente(connessione, nome, eta);

		}
		connessione.close();
	}

	public static void updateUtente(Connection connessione, String nome, int eta) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("update utente set eta =? where nome = ?;");

		statement.setInt(1, eta);
		statement.setString(2, nome);
		statement.execute();

	}

	public static void insertUtente(Connection connessione, String nome, int eta) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("insert into utente (nome, eta) values (?,?);");
		statement.setString(1, nome);
		statement.setInt(2, eta);
		statement.execute();

	}
	
	public static double getPrezzo(Connection connessione, String nomeProdotto)throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("select prezzo from prodotto where nomeProdotto = ?;");
		statement.setString(1, nomeProdotto);
		ResultSet ris = statement.executeQuery();
		while (ris.next()) {
			
			return ris.getDouble(1);
			
		}
		
		return 0;
	
		
	}
	

	public static int creaScontrino(Connection connessione, String nome) throws SQLException {
		
		PreparedStatement state = connessione.prepareStatement("insert into scontrino (idScontrino, data, nome) values (?,?,?);");
		java.util.Date data = new java.util.Date();
		DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		int idScontrino = (int) Math.random()*1000;
		state.setInt(1, idScontrino);
		state.setString(2, formato.format(data));
		state.setString(3, nome);
		state.execute();
		return idScontrino;
	}


}
