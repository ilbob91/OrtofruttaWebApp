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

	//List<ProdottoVenduto> carrello;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * if (carrello == null) {
		 * 
		 * carrello = new ArrayList<>(); }
		 */

		String azione = req.getParameter("azione");
		GestioneDB gestione;
		
		try {
			gestione = new GestioneDB();
			int idScontrino = Integer.parseInt(req.getParameter("idScontrino"));
			System.out.println(idScontrino);
			
String nomeUtente = req.getParameter("Utente");
					String nomeProdotto = req.getParameter("nomeProdotto");
					int quantita = Integer.parseInt(req.getParameter("quantita"));
			if (azione.equalsIgnoreCase("Aggiungi al carrello")) {
				try {

					

					if (gestione.checkVendita(gestione.stampaProdotti(), nomeProdotto, quantita)) {
						// carrello.add(new ProdottoVenduto(nomeUtente, nomeProdotto, quantita));
						gestione.inserimentoTabellaAcquisto(nomeUtente, nomeProdotto, quantita, idScontrino);
						gestione.updateQuantitaAggiuntaAlCarrello(nomeProdotto, quantita);
						req.setAttribute("Utente", nomeUtente);
						req.setAttribute("ListaProdotti", gestione.stampaProdotti());
						req.setAttribute("ListaProdottiDelloScontrino", gestione.stampaProdottiScontrino(idScontrino));
						req.setAttribute("messaggio", "prodotto aggiunto al carrello");
						req.setAttribute("idScontrino", idScontrino);

					} else {
						req.setAttribute("Utente", nomeUtente);
						req.setAttribute("ListaProdotti", gestione.stampaProdotti());
						req.setAttribute("ListaProdottiDelloScontrino", gestione.stampaProdottiScontrino(idScontrino));
						req.setAttribute("idScontrino", idScontrino);
						req.setAttribute("mess", "quantità del prodotto insufficiente");
						req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
					}
					gestione.close();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
			}

			else if (azione.equalsIgnoreCase("Paga")) {

				try {

					// GestioneDB gestione = new GestioneDB();

					/*
					 * for (ProdottoVenduto p : carrello) {
					 * 
					 * gestione.inserimentoTabellaAcquisto(p.getNomeCliente(), p.getNomeProdotto(),
					 * p.getQuantitaVenduta(), idScontrino); }
					 */
					
					if (req.getParameter("nomeProdotto")!=null && !req.getParameter("nomeProdotto").equals("")) {
						if (gestione.checkVendita(gestione.stampaProdotti(), nomeProdotto, quantita)) {
							// carrello.add(new ProdottoVenduto(nomeUtente, nomeProdotto, quantita));
							gestione.inserimentoTabellaAcquisto(nomeUtente, nomeProdotto, quantita, idScontrino);
							gestione.updateQuantitaAggiuntaAlCarrello(nomeProdotto, quantita);
							req.setAttribute("Utente", nomeUtente);
							req.setAttribute("ListaProdotti", gestione.stampaProdotti());
							req.setAttribute("ListaProdottiDelloScontrino", gestione.stampaProdottiScontrino(idScontrino));
							req.setAttribute("messaggio", "prodotto aggiunto al carrello");
							req.setAttribute("idScontrino", idScontrino);
							double spesa = gestione.getPrezzo(idScontrino);
							System.out.println(spesa);
							gestione.spesaTotaleScontrino(idScontrino, spesa);
							//carrello.clear();
							
					

						} else {
							req.setAttribute("Utente", nomeUtente);
							req.setAttribute("ListaProdotti", gestione.stampaProdotti());
							req.setAttribute("ListaProdottiDelloScontrino", gestione.stampaProdottiScontrino(idScontrino));
							req.setAttribute("idScontrino", idScontrino);
							req.setAttribute("mess", "quantità del prodotto insufficiente");
							req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp);
						}
					}

					double spesa = gestione.getPrezzo(idScontrino);
					System.out.println(spesa);
					gestione.spesaTotaleScontrino(idScontrino, spesa);
					//carrello.clear();
					gestione.close();
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				gestione.close();
				req.setAttribute("Utente", req.getParameter("Utente"));
				req.setAttribute("idScontrino", idScontrino);
				req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
