<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid #C70039;
}
</style>
<meta charset="ISO-8859-1">
<title>Update prodotti</title>
</head>
<body>
<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("ListaProdotti"); %>
<table>
  
    <h2>Lista Prodotti</h2>
  <tr>
   <th>Nome </th>
   <th>Quantità </th>
  </tr>
  <% for(Prodotto nome : listaProdotti) { %>
  
  <tr>
    <td>
    <%=nome.getNomeProdotto()%>
    </td>
    <td>
    <%=nome.getQuantitaResidua()%>
    </td>     
  </tr>
	<% } %> 
</table> <br><br>
<title>Vendita Prodotti</title>
</head>
<body>

<h1>Simula vendita prodotto</h1>
<form action="vendita" method="post">
  <label for="nomeProdotto">Dimmi il nome del prodotto</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
  <label for="quantita">Inserisci la quantità</label>
  <input type="number" id="quantita" name="quantita"><br><br>
  <input type="submit" style="width:120px; height:45px;" value="Simula Vendita">
  </form><br><br>
  
<form action="PaginaIniziale.jsp">
  <input type="submit" value="Torna Indietro">


  

</form>

</body>
</html>