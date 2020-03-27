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
		
		req.setAttribute("messaggio", "hai tentato di accedere manualmente alla rimozione prodotti");
		req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome1 = req.getParameter("nomeProdotto");
		try {
			GestioneDB gest = new GestioneDB();
			req.setAttribute("ListaProdotti",
					gest.getListaProdottiDopoRimozione(nome1));
			gest.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
	}
}

	