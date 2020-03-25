<%@page import="it.dstech.ortofruttawebapp.classi.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border: 1px solid #FF5733;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
	
		<%=messaggio%>
					
	<% }
	


%>
<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("ListaProdotti"); %>
<%String nome = (String) request.getAttribute("Utente"); %>
<table>
  
    <h2>Lista Prodotti</h2>
  <tr>
   <th>Nome </th>
   <th>Quantità </th>
   <th>Prezzo </th>
   
  </tr>
  <% for(Prodotto p : listaProdotti) { %>
  
  <tr>
    <td>
    <%=p.getNomeProdotto()%>
    </td>
    <td>
    <%=p.getQuantitaResidua()%>
    </td>     
    <td>
    <%=p.getPrezzo()%>
    </td>  
  </tr>
	<% } %> 
</table> <br><br>
<h2>Cosa vuoi comprare , <%=request.getAttribute("Utente")%> ?</h2>
<form action="acquisto" method = "post">
  <label for="nomeProdotto">Dimmi il nome del prodotto</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
  <label for="quantita">Inserisci la quantità che vuoi acquistare</label>
  <input type="number" id="quantita" name="quantita"><br><br>
  <input type="submit" style="background-color:#FF5733; border-color:#FF5733; color:white ;width:200px; height:45px;" name= "azione" value="Aggiungi al carrello">
  <input type="submit" style="background-color:#FF5733; border-color:#FF5733; color:white ;width:200px; height:45px;" name= "azione" value="Paga">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>
   <br><br>
   </form>
   <form action="tornaIndietro" method="post">
  <input type="submit" value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>  
</form>

</body>
</html>