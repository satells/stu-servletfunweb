<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty usuarioLogado}">
		<p>Logado como ${usuarioLogado.email}</p>
		<br>
	</c:if>
	<p>Bem vindo ao nosso gerenciador de empresas!</p>
	<br>
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="NovaEmpresa"> Nome:
		<input type="text" name="nome" /><br> <input type="submit"
			value="Enviar" />
	</form>

	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Login"> email: <input
			type="text" name="email" /><br> senha: <input type="password"
			name="senha" /><br> <input type="submit" value="Enviar" />
	</form>
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Logout"> <input
			type="submit" value="Logout">
	</form>


</body>
</html>