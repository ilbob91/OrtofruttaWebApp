<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Aggiunta prodotti</title>
</head>
<body>

<h1>Aggiungi prodotto</h1>
<br>
<form action="aggiungi" method="post">
<div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Nome Prodotto</span>
  </div>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
</div>
  
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Quantità</span>
  </div>
  <input type="number" id="quantita" name="quantita"><br><br>
</div>
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Prezzo</span>
  </div>
  <input type="text" id="prezzo" name="prezzo"><br><br>
</div>
  <div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm">Descrizione</span>
  </div>
  <input type="text" id="descrizione" name="descrizione"><br><br>
</div>
  <input type="submit" class="btn btn-outline-success" style="width:120px; height:45px;" value="Aggiungi">
  </form><br><br>
  
<form action="PaginaInizialeVenditore.jsp">
  <input type="submit" class="btn btn-outline-secondary" value="Torna Indietro">


  

</form>
</body>
</html>