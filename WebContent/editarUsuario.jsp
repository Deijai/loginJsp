<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição de Usuário</title>
</head>
<body>

<h1>Cadastro de Usuário</h1>

		<form action="UsuarioServelet" method="post">
		
			<label>Usuario:</label>
			<input type="text" name="usuario" value="${user.usuario }">
			<br>
			<label>Senha:</label>
			<input type="password" name="senha" value="${user.senha }">
			<br>
			<input type="submit" name="edit" value="Editar">
		</form>

</body>
</html>