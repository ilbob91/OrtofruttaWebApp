package it.dstech.ortofruttawebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.ortofruttawebapp.classi.Prodotto;

public class AggiornaLista extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeProdotto1 = req.getParameter("nomeProdotto");
		int quantita1 = Integer.parseInt(req.getParameter("quantita"));
		try {
			req.setAttribute("ListaProdottiAggiornati", updateQuantita(connessione(), nomeProdotto1, quantita1));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdottiAggiornati.jsp").forward(req, resp);
	}

	private static Connection connessione() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "bBrurP57M6";
		String username = "rMIwGtutXd";
		String url = "jdbc:mysql://remotemysql.com:3306/rMIwGtutXd?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		return connessione;
	}

	private static List<Prodotto> updateQuantita(Connection connessione, String name, int q)
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

	private static List<Prodotto> stampaProdotti(Connection connessione) throws SQLException {
		PreparedStatement statement2 = connessione.prepareStatement("select * from Prodotto");

		ResultSet risultatoQuery = statement2.executeQuery();
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

}
