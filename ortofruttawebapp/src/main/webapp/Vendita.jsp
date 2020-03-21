<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Vendi prodotto</h1>
<form action="vendita">
  <label for="nomeProdotto">Dimmi il nome del prodotto</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
  <label for="quantita">Inserisci la quantità</label>
  <input type="number" id="quantita" name="quantita"><br><br>
  <input type="submit" style="width:120px; height:45px;" value="Vendi">
  </form><br><br>
  
<form action="PaginaIniziale.jsp">
  <input type="submit" value="Torna Indietro">


  

</form>

</body>
</html>