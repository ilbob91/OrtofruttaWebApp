package it.dstech.ortofruttacliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.ortofruttawebapp.GestioneDB;
import it.dstech.ortofruttawebapp.classi.Prodotto;
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;

public class AcquistoCliente extends HttpServlet {

	List<ProdottoVenduto> carrello;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (carrello == null) {
			carrello = new ArrayList<>();
		}
		String azione = req.getParameter("azione");
		

		if (azione.equalsIgnoreCase("Aggiungi al carrello")) {
			try {
				String nomeUtente = req.getParameter("Utente");
				String nomeProdotto = req.getParameter("nomeProdotto");
				int quantita = Integer.parseInt(req.getParameter("quantita"));

				if (GestioneDB.checkVendita(GestioneDB.stampaProdotti(GestioneDB.connessione()), quantita)) {
					carrello.add(new ProdottoVenduto(nomeUtente, nomeProdotto, quantita));
					System.out.println(carrello);
					GestioneDB.updateQuantitaAggiuntaAlCarrello(GestioneDB.connessione(), nomeProdotto, quantita);
					req.setAttribute("Utente", nomeUtente);
					req.setAttribute("messaggio", "prodotto aggiunto al carrello");
					req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
				} else {
					req.setAttribute("mess", "quantità del prodotto insufficiente");
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Paga")) {
			String nomeUtente = req.getParameter("Utente");
			String nomeProdotto = req.getParameter("nomeProdotto");
			int quantita = Integer.parseInt(req.getParameter("quantita"));

			try {
				System.out.println(GestioneDB.getPrezzo(GestioneDB.connessione(), nomeProdotto));
				int idScontrino = GestioneDB.creaScontrino(GestioneDB.connessione(), nomeUtente);
				GestioneDB.inserimentoTabellaAcquisto(GestioneDB.connessione(), nomeUtente, nomeProdotto, quantita);

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			req.setAttribute("Utente", nomeUtente);
			req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
		}

	}

}
