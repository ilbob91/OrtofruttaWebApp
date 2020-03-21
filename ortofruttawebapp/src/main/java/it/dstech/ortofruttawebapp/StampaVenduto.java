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
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;

public class StampaVenduto extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			req.setAttribute("StampaVenduto", stampaVenduto(GestioneMagazzino.connessione()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("StampaVenduto.jsp").forward(req, resp);
	}
	private static List<ProdottoVenduto> stampaVenduto(Connection connessione)
			throws SQLException, ClassNotFoundException {

	List<ProdottoVenduto>elenco = new ArrayList<>();
		ResultSet risultato =	stampaListaVenduto(connessione);
		while (risultato.next()) {
			String nome = risultato.getString(1);
			int quantita = risultato.getInt(2);
			ProdottoVenduto p = new ProdottoVenduto(nome, quantita);
			elenco.add(p);
			
		}
		return elenco;
	}
	private static ResultSet stampaListaVenduto(Connection connessione) throws SQLException{
	
			PreparedStatement statement2 = connessione.prepareStatement("select * from Vendita");

			ResultSet risultatoQuery2 = statement2.executeQuery();
			return risultatoQuery2;
		
	}
}
