<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.mekylei.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
	<c:import url="logoutParcial.jsp"/>
	Usuário logado: ${usuarioLogado.login}

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - ${empresa.data} <a href="/gerenciador/entrada?id=${empresa.id}&acao=CarregaDadosEdicao">Editar</a> | <a href="/gerenciador/entrada?id=${empresa.id}&acao=DeletaEmpresas">Deletar</a></li>
		</c:forEach>
	</ul>

</body>
</html>