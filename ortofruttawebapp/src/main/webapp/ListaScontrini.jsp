<%@page import="java.util.List"%>
<%@page import="it.dstech.ortofruttawebapp.classi.Scontrino"%>
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

<% List<Scontrino> listaScontrini = (List<Scontrino>)request.getAttribute("ListaScontrini"); %>
<%String nomeUtente = (String) request.getAttribute("Utente"); %>
<table class="table table-striped">
  
    <h2>Lista Scontrino</h2>
  <tr>
   <th>idScontrino </th>
   <th>Nome </th>
   <th>Data </th>
   <th>Spesa </th>
    <th>Dettagli </th>
    
  </tr>
  <% for(Scontrino s : listaScontrini) { %>
  
  <tr>
    <td>
    <%=s.getIdScontrino()%>
    </td>
    <td>
    <%=s.getNome()%>
    </td>  
     <td>
    <%=s.getData()%>
    </td>    
     <td>
    <%=s.getSpesaTotale()%>
    </td> 
    <td>
    <form action="prodotti">
  <input type="submit" name="azione" value="Dettagli">
  <input type="hidden" id="Utente" name="Utente" value=<%=nomeUtente%>> 
  <input type="number" hidden="true" id="id" name="id" value=<%=s.getIdScontrino()%>>
	</form>  
	</td>    
  </tr>
  <% } %> 
	
</table> <br><br>
<form action="tornaIndietro" method="post">
  <input type="submit" class="btn btn-outline-secondary" value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nomeUtente%>>  
</form>
</body>
</html>