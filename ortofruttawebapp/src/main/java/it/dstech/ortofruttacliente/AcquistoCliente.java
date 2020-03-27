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
				GestioneDB gestione = new GestioneDB();
				String nomeUtente = req.getParameter("Utente");
				String nomeProdotto = req.getParameter("nomeProdotto");
				int quantita = Integer.parseInt(req.getParameter("quantita"));

				List<Prodotto> stampaProdotti = gestione.stampaProdotti();
				if (gestione.checkVendita(stampaProdotti, nomeProdotto, quantita)) {
					carrello.add(new ProdottoVenduto(nomeUtente, nomeProdotto, quantita));
					gestione.updateQuantitaAggiuntaAlCarrello(nomeProdotto, quantita);
					req.setAttribute("Utente", nomeUtente);
					req.setAttribute("messaggio", "prodotto aggiunto al carrello");
					req.setAttribute("ListaProdotti", stampaProdotti);
				} else {
					req.setAttribute("mess", "quantità del prodotto insufficiente");
				}
				gestione.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Paga")) {

			try {
				GestioneDB gest = new GestioneDB();
				int idScontrino = gest.creaScontrino(req.getParameter("Utente"));
				for (ProdottoVenduto p : carrello) {

					gest.inserimentoTabellaAcquisto(p.getNomeCliente(), p.getNomeProdotto(), p.getQuantitaVenduta(),
							idScontrino);
				}
				double spesa = gest.getPrezzo(idScontrino);
				System.out.println(spesa);
				gest.spesaTotaleScontrino(idScontrino, spesa);
				carrello.clear();
				gest.close();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			req.setAttribute("Utente", req.getParameter("Utente"));
			req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
		}

	}

}
