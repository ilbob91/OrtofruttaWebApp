package it.dstech.ortofruttawebapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestioneStampaListe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		if (azione.equalsIgnoreCase("Aggiorna un prodotto")) {

			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("AggiornaLista.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Rimuovi un prodotto")) {
			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("RimuoviProdotto.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Vendi un prodotto")) {
			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("Vendita.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Stampa i prodotti")) {
			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
		}
	}
}
