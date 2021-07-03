<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de Edição</title>
</head>
<body>

<c:url value="/alteraCadastro" var="linkAlteraCadastroServlet"/>


	<form id="form-1" action="${linkAlteraCadastroServlet}"  method="post">
		<label for="input-1">Id:</label>
		<input id="input-1" name="id" placeholder="Id" readonly="readonly" type="text" value="${empresa.id}"/>
	
		<label for="input-1">Nome:</label>
		<input id="input-1" name="nome" placeholder="Nome" type="text" value="${empresa.nome}"/>
		
		<label for="input-2">Data:</label>
		<input id="input-2" name="data" placeholder="Data de Inauguração" type="text" value="${empresa.data}"/>
		
		<input type="submit" value="Enviar" id="button-1"/>
	</form>

</body>
</html>