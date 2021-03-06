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
			GestioneDB gest = new GestioneDB();
			req.setAttribute("ListaProdottiVenduti", gest.stampaVenduto());
			gest.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdottiVenduti.jsp").forward(req, resp);
	}
	
}
