<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
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

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h3>ERRORE</h3>
		<%=messaggio%>
					
	<% }
	else{


%>

<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("ListaProdotti"); %>
<table>
  
    <h2>Lista Prodotti</h2>
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
</table> <br><br>
<form action="PaginaIniziale.jsp">
  <input type="submit" value="Torna Indietro">

</form>
</body>
</html>