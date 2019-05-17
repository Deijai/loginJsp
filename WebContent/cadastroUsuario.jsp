<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

<h1>Cadastro de Usuário</h1>

		<form action="UsuarioServelet" method="post">
		
			<label>Id:</label>
			<input type="text" name="id" value="${user.id }">
			<br>
		
			<label>Usuario:</label>
			<input type="text" name="usuario" value="${user.usuario }">
			<br>
			<label>Senha:</label>
			<input type="password" name="senha" value="${user.senha }">
			<br>
			<input type="submit" value="Cadastrar">
		</form>
		
		<table>
		  <c:forEach items="${usuarios}" var="user">
		    <tr>
		    	<td><c:out value="${user.id }"></c:out> </td>
		    	<td><c:out value="${user.usuario }"></c:out> </td>
		    	<td><c:out value="${user.senha }"></c:out> </td>
		    	<td><a href="UsuarioServelet?acao=excluir&id=${user.id }">Excluir</a></td>
		    	<td><a href="UsuarioServelet?acao=editar&id=${user.id }">Editar</a></td>
		    </tr>
		  </c:forEach>
		</table>

</body>
</html>