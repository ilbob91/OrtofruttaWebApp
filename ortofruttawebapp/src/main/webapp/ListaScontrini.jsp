<%@page import="java.util.List"%>
<%@page import="it.dstech.ortofruttawebapp.classi.Scontrino"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid #FF6347;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Scontrino> listaScontrini = (List<Scontrino>)request.getAttribute("ListaScontrini"); %>
<%String nomeUtente = (String) request.getAttribute("Utente"); %>
<table>
  
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
  <input type="submit" value="Torna Indietro">
  <input type="hidden" id="Utente" name="Utente" value=<%=nomeUtente%>>  
</form>
</body>
</html>