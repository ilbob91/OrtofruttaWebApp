package it.dstech.ortofruttawebapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AggiornaLista extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("messaggio", "hai tentato di accedere manualmente all'aggiornamento dei prodotti");
		req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeProdotto1 = req.getParameter("nomeProdotto");
		int quantita1 = Integer.parseInt(req.getParameter("quantita"));
		try {
			GestioneDB gest = new GestioneDB();
			req.setAttribute("ListaProdotti",
					gest.updateQuantita(nomeProdotto1, quantita1));
			gest.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
	}


}
