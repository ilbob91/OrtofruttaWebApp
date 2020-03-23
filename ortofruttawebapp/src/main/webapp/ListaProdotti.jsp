<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<table>
  <tr>
    <th>Lista Prodotti</th>
  </tr>	
  <% for(Prodotto nome : listaProdotti) { %>
  <tr>
    <td>
				<%=nome%>
	</td>  
  </tr>
	<% } %>
	<% } %> <br><br>
</table>
<form action="PaginaIniziale.jsp">
  <input type="submit" value="Torna Indietro">

</form>
</body>
</html>