<%@page import="it.dstech.ortofruttawebapp.classi.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Opzioni cliente</title>
</head>
<body>
<%String nome = (String) request.getAttribute("Utente"); %>

<h2><p class="text-xl-center">Benvenuto/a, <%=nome%></p></h2><br><br>

<form action="prodotti">
  <input type="submit"  class= "btn btn-outline-primary btn-block" style="width:300px; height:60px;margin:auto" name= "azione" value="Compra">
  <br><br>
  
   <input type="submit"  class= "btn btn-outline-primary btn-block" style="width:300px; height:60px;margin:auto" name= "azione" value="Stampa Scontrini">
  <input type="hidden" id="Utente" name="Utente" value=<%=nome%>>
</form> <br><br>
       
  <form action="PaginaInizialeCliente.jsp">
  <input type="submit" class="btn btn-outline-secondary btn-block"style="width:200px; height:45px;margin:auto" value="Torna Indietro">

</form>     
</body>
</html>