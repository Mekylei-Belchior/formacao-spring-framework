<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação</title>
</head>
<body>

	<c:if test="${empty empresa}">		
		<p>Informe os dados de cadastro.</p>	
	</c:if>
	
	<c:if test="${not empty empresa}">		
		<p>A empresa (${empresa}) foi cadastrada com sucesso!</p>	
	</c:if>

</body>
</html>