<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.mekylei.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:url value="/entrada" var="linkEntradaServlet"/>


	<form id="form-1" action="${linkEntradaServlet}"  method="post">
		<label for="input-1">Usuario:</label>
		<input id="input-1" name="login" placeholder="Login" type="text"/>
		
		<label for="input-2">Senha:</label>
		<input id="input-2" name="senha" placeholder="Senha" type="password"/>
		
		<input id="input-3" name="acao" type="hidden" value="Login"/>
		
		<input type="submit" value="Enviar" id="button-1"/>
	</form>

</body>
</html>