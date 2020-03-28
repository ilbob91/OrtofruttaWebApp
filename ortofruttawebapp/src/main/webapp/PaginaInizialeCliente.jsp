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
<br>
<h2><p class="text-xl-center">Registrazione</p></h2><br><br>
<form action="cliente" method="post">
  <div class="cliente">
  
    <p class="text-xl-center">Nome</p>
    <input type="text" class="form-control" id="user" name="user" style="width:250px; height:50px;margin:auto" placeholder="Nome">
</div><br>
  <div class="cliente">
    <p class="text-xl-center">Età</p>
    <input type="number" class="form-control" id="eta" name="eta" style="width:250px; height:50px;margin:auto" placeholder="Età">
  </div> <br>
  <input type="submit"class="btn btn-outline-primary btn-block" style="width:150px; height:45px;margin:auto" value="Entra">
</form>
<br><br>

 
  

  
<form action="Home.jsp">
  <input type="submit"  class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
</body>
</html>