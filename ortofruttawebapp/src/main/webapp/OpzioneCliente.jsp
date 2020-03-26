<%@page import="it.dstech.ortofruttawebapp.classi.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Opzioni cliente</title>
</head>
<body>
<%String nome = (String) request.getAttribute("Utente"); %>

<h2>Benvenuto/a, <%=nome%></h2>
<form action="prodotti">
  <input type="submit" style="background-color:#FF5733; border-color:#FF5733; color:white ;width:200px; height:45px;" name= "azione" value="Compra">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>
</form> <br><br>
       
  <form action="PaginaInizialeCliente.jsp">
  <input type="submit" value="Torna Indietro">

</form>     
</body>
</html>