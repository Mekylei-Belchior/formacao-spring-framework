<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.aula.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de Cadastro</title>
</head>
<body>
<c:url value="/cadastro" var="linkCadastroServlet"/>


	<form id="form-1" action="${linkCadastroServlet}"  method="post">
		<label for="input-1">Nome:</label>
		<input id="input-1" name="nome" placeholder="Nome" type="text"/>
		
		<label for="input-2">Data:</label>
		<input id="input-2" name="data" placeholder="Data de Inauguração" type="text"/>
		
		<input type="submit" value="Enviar" id="button-1"/>
	</form>

</body>
</html>