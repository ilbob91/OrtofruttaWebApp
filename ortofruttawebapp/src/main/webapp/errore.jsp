<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("messaggio")%> 
<br><br>


<form action="PaginaIniziale.jsp">
<input type="submit" value="Torna Indietro"> </form>
</body>
</html>