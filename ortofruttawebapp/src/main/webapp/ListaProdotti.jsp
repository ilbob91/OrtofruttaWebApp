<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
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

<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("ListaProdotti"); %>

  
   
 

<table  class="table table-striped"> 
   
  <tr>
   <th>Nome </th>
   <th>Quantità </th>
   <th>Prezzo </th>
   <th>Descrizione </th>
  </tr>
  <% for(Prodotto nome : listaProdotti) { %>
  
  <tr>
    <td>
    <%=nome.getNomeProdotto()%>
    </td>
    <td>
    <%=nome.getQuantitaResidua()%>
    </td>  
     <td>
    <%=nome.getPrezzo()%>
    </td>    
     <td>
    <%=nome.getDescrizione()%>
    </td>       
  </tr>
  <% } %> 
	<% } %> 
</table> <br>
<form action="PaginaInizialeVenditore.jsp">
  <input type="submit" class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto"  value="Torna Indietro">

</form>
</body>
</html>