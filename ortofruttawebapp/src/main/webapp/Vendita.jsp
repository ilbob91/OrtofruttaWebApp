<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
<style>
table, th, td {
  border: 1px solid #000000;
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
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Nome del Prodotto</span>
  </div>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br></div>
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Inserisci la quantità</span>
  </div>
  <input type="number" id="quantita" name="quantita"><br><br></div>
  <input type="submit" class="btn btn-outline-success" style="width:120px; height:45px;" value="Simula Vendita">
  </form><br>
  
<form action="PaginaInizialeVenditore.jsp">
  <input type="submit" class="btn btn-outline-secondary" value="Torna Indietro">


  

</form>

</body>
</html>