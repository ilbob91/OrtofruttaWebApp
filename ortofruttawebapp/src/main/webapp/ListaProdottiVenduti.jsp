
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

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h3>ERRORE</h3>
		<%=messaggio%>
					
	<% }
	else{


%>

<% List<ProdottoVenduto> listaProdotti = (List<ProdottoVenduto>)request.getAttribute("ListaProdottiVenduti"); %>
<table class="table table-striped">
  
    <h2>Lista Prodotti Venduti</h2>
  <tr>
   <th>Nome </th>
   <th>Quantità </th>
   
  </tr>
  <% for(ProdottoVenduto nome : listaProdotti) { %>
  
  <tr>
    <td>
    <%=nome.getNomeProdotto()%>
    </td>
    <td>
    <%=nome.getQuantitaVenduta()%>
    </td>  
      
  </tr>
  <% } %> 
	<% } %>
</table><br>
<form action="PaginaInizialeVenditore.jsp">
  <input type="submit" class="btn btn-outline-secondary" value="Torna Indietro">

</form>
</body>
</html>