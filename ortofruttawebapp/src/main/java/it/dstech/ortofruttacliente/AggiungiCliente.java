package it.dstech.ortofruttacliente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.ortofruttawebapp.GestioneDB;
import it.dstech.ortofruttawebapp.classi.Utente;


public class AggiungiCliente extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("user");
		int eta = Integer.parseInt(req.getParameter("eta"));
		
		
		try {
			GestioneDB.checkUtente(GestioneDB.connessione(), nome, eta);
			req.setAttribute("Utente", nome);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
	}

		
	}


