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
		} else if (azione.equalsIgnoreCase("Compra")) {
			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
				req.setAttribute("Utente", req.getParameter("Utente"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
		}
		else if (azione.equalsIgnoreCase("Stampa Scontrini")) {
			try {
				req.setAttribute("ListaScontrini", GestioneDB.stampaScontrini(GestioneDB.connessione(), req.getParameter("Utente")));
				req.setAttribute("Utente", req.getParameter("Utente"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaScontrini.jsp").forward(req, resp);
		}
		else if (azione.equalsIgnoreCase("Dettagli")) {
			try {
				req.setAttribute("Utente", req.getParameter("Utente"));
				int idScontrino = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("id", idScontrino);
				req.setAttribute("ListaProdottiDelloScontrino", GestioneDB.stampaProdottiScontrino(GestioneDB.connessione(), idScontrino));
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("ListaProdottiDelloScontrino.jsp").forward(req, resp);
		}
	}
}
