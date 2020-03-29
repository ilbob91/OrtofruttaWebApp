<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Ortofrutta</title>
</head>
<body>
<br>
<h2><p class="text-xl-center">Scegli</p></h2><br><br>
<% String password = (String) request.getAttribute("password");%>
<form action="AggiungiProdotto.jsp">
  <input type="submit" class= "btn btn-outline-primary btn-block" style="width:300px; height:60px;margin:auto" name= "azione" value="Aggiungi un prodotto">
  </form>
  <br>
<form action="prodotti">
  <input type="submit" class= "btn btn-outline-primary btn-block"style="width:300px; height:60px;margin:auto" name= "azione" value="Aggiorna un prodotto">
   <br>
  <input type="submit" class= "btn btn-outline-primary btn-block"style="width:300px; height:60px;margin:auto" name= "azione" value="Rimuovi un prodotto">
   <br>
   <input type="submit" class= "btn btn-outline-primary btn-block"style="width:300px; height:60px;margin:auto" name= "azione" value="Stampa i prodotti">
   <br>
  <input type="submit" class= "btn btn-outline-primary btn-block"style="width:300px; height:60px;margin:auto" name= "azione" value="Vendi un prodotto">
  </form>
  <br>

<form action="venduto">
  <input type="submit" class= "btn btn-outline-primary btn-block"style="width:300px; height:60px;margin:auto" name= "azione" value="Stampa venduto">
  </form> 
 <br><br>
 
   <form action="Home.jsp">
  <input type="submit"class="btn btn-outline-secondary btn-block"style="width:200px; height:45px;margin:auto" value="Torna Indietro">

</form>   
       
</body>
</html>