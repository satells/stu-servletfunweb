<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


<c:if test="${not empty usuarioLogado}">
	 Logado como ${usuarioLogado.email}<br>
</c:if>


	Bem vindo ao nosso gerenciador de empresas!
	<br>
	<form action="novaEmpresa" method="post">
			Nome: <input type="text" name="nome"/><br>
			<input type="submit" value="Enviar"/>
	</form>
	
	<form action="login" method="post">
		email: <input type="text" name="email"/><br>
		senha: <input type="password" name="senha"/><br>
		<input type="submit" value="Enviar"/>
		
	
	</form>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
	
	
</body>
</html>