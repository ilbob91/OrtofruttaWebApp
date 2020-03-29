<%@page import="it.dstech.ortofruttawebapp.classi.ProdottoVenduto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<ProdottoVenduto> lista = (List<ProdottoVenduto>)request.getAttribute("ListaProdottiDelloScontrino"); %>
<%String nomeUtente = (String) request.getAttribute("Utente"); %>
<table class="table table-striped">
  
    <h2>Lista Prodotti Scontrino</h2>
  <tr>
   <th>idScontrino </th>
   <th>Nome </th>
   <th>Nome Prodotto </th>
   <th>Quantità </th>
    
  </tr>
  <% for(ProdottoVenduto p : lista) { %>
  
  <tr>
    <td>
    <%=p.getIdScontrino()%>
    </td>
    <td>
    <%=p.getNomeCliente()%>
    </td>  
     <td>
    <%=p.getNomeProdotto()%>
    </td>    
     <td>
    <%=p.getQuantitaVenduta()%>
       </td> 
  </tr>
  <% } %> 
	
</table><br><br>
<form action="tornaIndietro" method="post">
  <input type="submit" class="btn btn-outline-secondary" value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nomeUtente%>>  
</form>
</body>
</html>