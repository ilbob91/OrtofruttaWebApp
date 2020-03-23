<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ortofrutta</title>
</head>
<body>
<form action="AggiungiProdotto.jsp">
  <input type="submit" style="background-color:#FFC300; border-color:#FFC300; color:white ;width:200px; height:45px;" name= "azione" value="Aggiungi un prodotto">
  </form>
  <br>
<form action="prodotti">
  <input type="submit" style="background-color:#FF5733; border-color:#FF5733; color:white ;width:200px; height:45px;" name= "azione" value="Aggiorna un prodotto">
   <br><br>
  <input type="submit" style="background-color:#581845; border-color:#581845; color:white ;width:200px; height:45px;" name= "azione" value="Rimuovi un prodotto">
   <br><br>
   <input type="submit" style="background-color:#FF6347; border-color:#FF6347; color:white ;width:200px; height:45px;" name= "azione" value="Stampa i prodotti">
   <br><br>
  <input type="submit" style="background-color:#C70039; border-color:#C70039; color:white ;width:200px; height:45px;" name= "azione" value="Vendi un prodotto">
  </form>
  <br>

<form action="venduto">
  <input type="submit" style="background-color:#900C3F; border-color:#900C3F; color:white ;width:200px; height:45px;" name= "azione" value="Stampa venduto">
  </form> 
 <br>
       
</body>
</html>