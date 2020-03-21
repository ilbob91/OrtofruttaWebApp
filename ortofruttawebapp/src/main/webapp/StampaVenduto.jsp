<%@page import="it.dstech.ortofruttawebapp.classi.ProdottoVenduto"%>
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
<% List<ProdottoVenduto> listaProdottiVenduti = (List<ProdottoVenduto>)request.getAttribute("StampaVenduto"); %>
<table>
  <tr>
    <th>Prodotti Venduti</th>
  </tr>	
  <% for(ProdottoVenduto nome : listaProdottiVenduti) { %>
  <tr>
    <td>
				<%=nome%>
	</td>  
  </tr>
	<% } %>
</table><br><br>
<form action="PaginaIniziale.jsp">
  <input type="submit" value="Torna Indietro">

</form>

</body>
</html>