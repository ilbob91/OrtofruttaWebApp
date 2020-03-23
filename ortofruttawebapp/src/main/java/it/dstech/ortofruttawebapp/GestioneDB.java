package it.dstech.ortofruttawebapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dstech.ortofruttawebapp.classi.Prodotto;
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;

public class GestioneDB {
	public static Connection connessione() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "bBrurP57M6";
		String username = "rMIwGtutXd";
		String url = "jdbc:mysql://remotemysql.com:3306/rMIwGtutXd?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
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

	public static boolean checkVendita(List<Prodotto> elenco, int q) {

		for (int i = 0; i < elenco.size(); i++) {

			if (q > elenco.get(i).getQuantitaResidua()) {

				return false;

			}
			return true;

		}
		return true;
	}

	/*
	 * private static List<Prodotto> stampaProdotti(Connection connessione) throws
	 * SQLException { PreparedStatement statement2 =
	 * connessione.prepareStatement("select * from Prodotto");
	 * 
	 * ResultSet risultatoQuery = statement2.executeQuery(); List<Prodotto> elenco =
	 * new ArrayList<>(); while (risultatoQuery.next()) { String nome =
	 * risultatoQuery.getString("nomeProdotto"); int quantita =
	 * risultatoQuery.getInt("quantitaResidua"); double prezzo =
	 * risultatoQuery.getDouble("prezzo"); String descrizione =
	 * risultatoQuery.getString("descrizione");
	 * 
	 * Prodotto prodotto = new Prodotto(nome, quantita, prezzo, descrizione);
	 * elenco.add(prodotto); } return elenco; }
	 */
	public static List<Prodotto> stampaProdotti(Connection connessione) throws SQLException {
		PreparedStatement state = connessione.prepareStatement("select * from Prodotto");

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
		PreparedStatement statement2 = connessione.prepareStatement("select * from Vendita");

		ResultSet risultatoQuery2 = statement2.executeQuery();
		return risultatoQuery2;
	}

	private static void inserimentoTabellaVendita(Connection connessione, String name, int q) throws SQLException {
		PreparedStatement statement1 = connessione
				.prepareStatement("insert into Vendita (nomeProdotto, quantitaVenduta) values (?,?);");
		statement1.setString(1, name);
		statement1.setInt(2, q);
		statement1.execute();
	}

	private static void updateTabellaProdotti(Connection connessione, String name, int sottrazione)
			throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update Prodotto set quantitaResidua = ? where nomeProdotto = ?;");
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
		return null;
	}

	private static void removeProdotti(Connection connessione, String name) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("delete from Prodotto where nomeProdotto = ?;");
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

	/*
	 * private static List<Prodotto> stampaProdotti(Connection connessione) throws
	 * SQLException { PreparedStatement statement2 =
	 * connessione.prepareStatement("select * from Prodotto");
	 * 
	 * ResultSet risultatoQuery = statement2.executeQuery(); List<Prodotto> elenco =
	 * new ArrayList<>(); while (risultatoQuery.next()) { String nome =
	 * risultatoQuery.getString("nomeProdotto"); int quantita =
	 * risultatoQuery.getInt("quantitaResidua"); double prezzo =
	 * risultatoQuery.getDouble("prezzo"); String descrizione =
	 * risultatoQuery.getString("descrizione");
	 * 
	 * Prodotto prodotto = new Prodotto(nome, quantita, prezzo, descrizione);
	 * elenco.add(prodotto); } return elenco; }
	 */

	private static void inserisciProdotti(Prodotto p, Connection connessione) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement(
				"insert into Prodotto (nomeProdotto, quantitaResidua, prezzo, descrizione) values (?,?,?,?);");
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

	/*
	 * private static ResultSet stampaListaVenduto(Connection connessione) throws
	 * SQLException{
	 * 
	 * PreparedStatement statement2 =
	 * connessione.prepareStatement("select * from Vendita");
	 * 
	 * ResultSet risultatoQuery2 = statement2.executeQuery(); return
	 * risultatoQuery2;
	 * 
	 * }
	 */
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
		return null;
	}

	private static void updateProdotti(Connection connessione, String name, int somma) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("update Prodotto set quantitaResidua = ? where nomeProdotto = ?;");
		statement.setString(2, name);
		statement.setInt(1, somma);
		statement.execute();
	}

	/*
	 * private static List<Prodotto> stampaProdotti(Connection connessione) throws
	 * SQLException { PreparedStatement statement2 =
	 * connessione.prepareStatement("select * from Prodotto");
	 * 
	 * ResultSet risultatoQuery = statement2.executeQuery(); List<Prodotto> elenco =
	 * new ArrayList<>(); while (risultatoQuery.next()) { String nome =
	 * risultatoQuery.getString("nomeProdotto"); int quantita =
	 * risultatoQuery.getInt("quantitaResidua"); double prezzo =
	 * risultatoQuery.getDouble("prezzo"); String descrizione =
	 * risultatoQuery.getString("descrizione");
	 * 
	 * Prodotto prodotto = new Prodotto(nome, quantita, prezzo, descrizione);
	 * elenco.add(prodotto); } return elenco; }
	 */

}
