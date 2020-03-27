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
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaProdotti", gestione.stampaProdotti());
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("AggiornaLista.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Rimuovi un prodotto")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaProdotti", gestione.stampaProdotti());
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("RimuoviProdotto.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Vendi un prodotto")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaProdotti", gestione.stampaProdotti());
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("Vendita.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Stampa i prodotti")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaProdotti", gestione.stampaProdotti());
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Compra")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaProdotti", gestione.stampaProdotti());
				req.setAttribute("Utente", req.getParameter("Utente"));
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
		}
		else if (azione.equalsIgnoreCase("Stampa Scontrini")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("ListaScontrini", gestione.stampaScontrini(req.getParameter("Utente")));
				req.setAttribute("Utente", req.getParameter("Utente"));
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaScontrini.jsp").forward(req, resp);
		}
		else if (azione.equalsIgnoreCase("Dettagli")) {
			try {
				GestioneDB gestione = new GestioneDB();
				req.setAttribute("Utente", req.getParameter("Utente"));
				int idScontrino = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("id", idScontrino);
				req.setAttribute("ListaProdottiDelloScontrino", gestione.stampaProdottiScontrino(idScontrino));
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaProdottiDelloScontrino.jsp").forward(req, resp);
		}
	}
}
