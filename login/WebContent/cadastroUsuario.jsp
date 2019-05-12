<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

<h1>Cadastro de Usuário</h1>

<form action="UsuarioServelet" method="post">

<label>Usuario:</label>
<input type="text" name="usuario">
<br>
<label>Senha:</label>
<input type="password" name="senha">
<br>
<input type="submit" value="Cadastrar">
</form>

</body>
</html>