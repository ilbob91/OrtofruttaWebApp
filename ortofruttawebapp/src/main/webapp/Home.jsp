<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
<style>
header {
   
    top: 0;
    left: 0;
    right: 0;
    height: 100px;
    line-height: 100px;
    background-color:  lightblue;
}


</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <header>
     <h1><p class="text-xl-center font-weight-bold">BENVENUTI NELL'ORTOFRUTTA DI MARTA E BOB</p></h1>
<br><br>       
        </header>
   
<main>
            <section id="hero">
                <h4><p class="text-xl-center font-weight-bold">Sei il Venditore?</p></h4>
<form action="PaginaInizialeVenditore.jsp">
  <input type="submit"   class="btn btn-outline-primary btn-block" style="width:150px; height:50px;margin:auto" value="Venditore">
  </form><br><br>
  
<h4><p class="text-xl-center font-weight-bold">Sei il Cliente?</p></h4>
<form action="PaginaInizialeCliente.jsp">
  <input type="submit"  class="btn btn-outline-primary btn-block" style="width:150px; height:50px;margin:auto" value="Cliente">
  </form><br><br>
            </section>
        </main>
   
 
  
    
 
  
 


  
  
</body>
</html>