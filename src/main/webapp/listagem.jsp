<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.aula.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - ${empresa.data} <a href="/gerenciador/editar?id=${empresa.id}">Editar</a> | <a href="/gerenciador/deletar?id=${empresa.id}">Deletar</a></li>
		</c:forEach>
	</ul>

</body>
</html>