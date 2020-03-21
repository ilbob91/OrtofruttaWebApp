package it.dstech.ortofruttawebapp;

import java.io.IOException;
import java.sql.Connection;
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

public class RimuoviProdotto extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome1 = req.getParameter("nomeProdotto");
		try {
			req.setAttribute("ListaProdottiAggiornati",
					getListaProdottiDopoRimozione(AggiungiProdotto.connessione(), nome1));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdottiAggiornati.jsp").forward(req, resp);
	}

	private static List<Prodotto> getListaProdottiDopoRimozione(Connection connessione, String name)
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
		PreparedStatement statement = connessione
				.prepareStatement("delete from Prodotto where nomeProdotto = ?;");
		statement.setString(1, name);
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
