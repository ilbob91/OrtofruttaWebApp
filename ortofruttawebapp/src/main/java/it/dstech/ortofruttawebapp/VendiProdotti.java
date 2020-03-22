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
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;

public class VendiProdotti extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeProdotto1 = req.getParameter("nomeProdotto");
		int quantita1 = Integer.parseInt(req.getParameter("quantita"));
		try {
			req.setAttribute("ListaProdottiVenduti",
					GestioneDB.updateQuantitaVendute(GestioneDB.connessione(), nomeProdotto1, quantita1));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdottiVenduti.jsp").forward(req, resp);
	}

	
}
