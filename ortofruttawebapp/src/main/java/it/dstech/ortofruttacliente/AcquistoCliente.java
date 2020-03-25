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
import it.dstech.ortofruttawebapp.classi.ProdottoVenduto;

public class AcquistoCliente extends HttpServlet {

	List<ProdottoVenduto> carrello;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(carrello==null)
		{
			carrello=new ArrayList<>();
		}
		String azione = req.getParameter("azione");
		
		if (azione.equalsIgnoreCase("Aggiungi al carrello")) {
			String nomeProdotto = req.getParameter("nomeProdotto");
			int quantita = Integer.parseInt(req.getParameter("quantita"));
			//metodo di controllo quantita
			carrello.add(new ProdottoVenduto(nomeProdotto, quantita));
			req.setAttribute("Utente", req.getParameter("Utente"));
			req.setAttribute("messaggio", "prodotto aggiunto al carrello");
			try {
				req.setAttribute("ListaProdotti", GestioneDB.stampaProdotti(GestioneDB.connessione()));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	
			req.getRequestDispatcher("AcquistiCliente.jsp").forward(req, resp); 
	} else if (azione.equalsIgnoreCase("Paga")) {
			
			req.getRequestDispatcher("").forward(req, resp);
		}

	}
}
