package it.dstech.ortofruttacliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TornaIndietro extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("Utente", req.getParameter("Utente"));
	req.getRequestDispatcher("OpzioneCliente.jsp").forward(req, resp);
}
}
