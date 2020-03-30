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
<h2>Cosa vuoi comprare, <%=request.getAttribute("Utente")%> ?</h2>
<form action="acquisto" method = "post">
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm"><label for="nomeProdotto">Nome prodotto da acquistare</label></span>
     
	<select name = "nomeProdotto">
	
	<% for (Prodotto p1 : listaProdotti){%>
	  <option value="<%=p1.getNomeProdotto() %>"><%=p1.getNomeProdotto() %></option>
	  
	  <% } %>
	</select>
	<br>
  </div>
 <br><br></div>
   <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Inserisci quantità da acquistare</span>
  </div>
  <input type="number" id="quantita" name="quantita"><br><br></div><br>
  <input type="submit" class="btn btn-outline-success" style="height:45px;" name= "azione" value="Aggiungi al carrello">
  <input type="submit" class="btn btn-outline-danger" style="width:120px; height:45px;" name= "azione" value="Paga">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>
  <input type="hidden" id="idScontrino" name="idScontrino" value=<%=(int)request.getAttribute("idScontrino")%>>
   
   <br><br>
   </form>
   <form action="tornaIndietro" method="post">
  <input type="submit" class="btn btn-outline-secondary" style="width:120px; height:45px;"  value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>
</form>

</body>
</html>