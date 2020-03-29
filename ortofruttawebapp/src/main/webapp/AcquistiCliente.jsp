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
	
		<%=messaggio%>
					
	<% }
	


%>

<% String mess = (String) request.getAttribute("mess"); 
	if (mess != null ){
		%>
	
		<%=mess%>
					
	<% }
	


%>
<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("ListaProdotti"); %>
<%String nome = (String) request.getAttribute("Utente"); %>
<table class= "table table-striped">
  
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
<h2>Cosa vuoi comprare, <%=request.getAttribute("Utente")%> ?</h2>
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
  <input type="submit" class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto"  value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>  
</form>

</body>
</html>