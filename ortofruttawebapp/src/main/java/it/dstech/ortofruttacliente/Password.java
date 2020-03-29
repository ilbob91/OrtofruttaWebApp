package it.dstech.ortofruttacliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Password extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String password = req.getParameter("password");
	String passwordVera = "ciao";
	if(passwordVera.equalsIgnoreCase(password)) {
		req.setAttribute("password", password);
		req.getRequestDispatcher("PaginaInizialeVenditore.jsp").forward(req, resp);
	} else {
		req.setAttribute("mess", "password errata");
		req.getRequestDispatcher("PasswordVenditore.jsp").forward(req, resp);
	}
}
}
