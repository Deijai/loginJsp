<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>

<form action="LoginServelet" method="post">

<label>Login:</label>
<input type="text" name="login">
<br>
<label>Senha:</label>
<input type="password" name="senha">
<br>
<input type="submit" name="logar" value="Logar">
</form>

</body>
</html>