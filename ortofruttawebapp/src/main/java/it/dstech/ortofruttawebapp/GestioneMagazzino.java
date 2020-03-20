package it.dstech.ortofruttawebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.ortofruttawebapp.classi.Prodotto;

public class GestioneMagazzino extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String nomeProdotto = req.getParameter("nomeProdotto");
	int quantita = Integer.parseInt(req.getParameter("quantita"));
	double prezzo = Double.parseDouble(req.getParameter("prezzo"));
	String descrizione = req.getParameter("descrizione");
	Prodotto p = new Prodotto(nomeProdotto, quantita, prezzo, descrizione);
	try {
		req.setAttribute("ListaProdotti", getGestioneMagazzino(p));
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	req.getRequestDispatcher("ListaProdotti.jsp").forward(req, resp);	
	
	
	
	
}



	private static List<Prodotto> getGestioneMagazzino(Prodotto p) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "bBrurP57M6";
		String username = "rMIwGtutXd";
		String url = "jdbc:mysql://remotemysql.com:3306/rMIwGtutXd?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		
		PreparedStatement statement = connessione
				.prepareStatement("insert into Prodotto (nomeProdotto, quantitaResidua, prezzo, descrizione) values (?,?,?,?);");
		statement.setString(1, p.getNomeProdotto());
		statement.setInt(2, p.getQuantitaResidua());
		statement.setDouble(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
		statement.execute();

		PreparedStatement statement2 = connessione
				.prepareStatement("select * from Prodotto");
		
		ResultSet risultatoQuery = statement2.executeQuery();
		List<Prodotto> elenco = new ArrayList<>();
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("nomeProdotto");
			int quantita = risultatoQuery.getInt("quantitaResidua");
			double prezzo = risultatoQuery.getDouble("prezzo");
			String descrizione = risultatoQuery.getString("descrizione");
			
			Prodotto prodotto = new Prodotto(nome, quantita, prezzo, descrizione);
			elenco.add(prodotto);
		}
		connessione.close();
		return elenco;
		
	}

}
