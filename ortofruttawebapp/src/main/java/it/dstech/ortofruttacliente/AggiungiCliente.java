package it.dstech.ortofruttacliente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.ortofruttawebapp.GestioneDB;

public class AggiungiCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("user");
		int eta = Integer.parseInt(req.getParameter("eta"));
		
		try {
			GestioneDB gestione = new GestioneDB();
			gestione.checkUtente(nome, eta);
			req.setAttribute("Utente", nome);
			int idScontrino = gestione.creaScontrino(req.getParameter("Utente"));
		
			gestione.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
	}

}
