<%@page import="it.dstech.ortofruttawebapp.classi.ProdottoVenduto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid #FF6347;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<ProdottoVenduto> lista = (List<ProdottoVenduto>)request.getAttribute("ListaProdottiDelloScontrino"); %>
<%String nomeUtente = (String) request.getAttribute("Utente"); %>
<table>
  
    <h2>Lista Prodotti Venduti</h2>
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
  <input type="submit" value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nomeUtente%>>  
</form>
</body>
</html>