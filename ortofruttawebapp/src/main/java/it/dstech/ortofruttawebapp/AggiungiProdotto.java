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

public class AggiungiProdotto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeProdotto = req.getParameter("nomeProdotto");
		int quantita = Integer.parseInt(req.getParameter("quantita"));
		double prezzo = Double.parseDouble(req.getParameter("prezzo"));
		String descrizione = req.getParameter("descrizione");
		Prodotto p = new Prodotto(nomeProdotto, quantita, prezzo, descrizione);
		try {
			req.setAttribute("ListaProdotti", GestioneDB.getProdotti(p, GestioneDB.connessione()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
	}


	
}
