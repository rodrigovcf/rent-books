<%@page
	import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>
	<c:url value="/login" var="loginUrl" />
	<div id="error" class="alert alert-error" align="center">

		<c:if test="${param.error != null}">
			<font color="red"> Invalid Details </font>
		</c:if>
		<c:if test="${param.logout != null}">
			<font color="red"> You have been logged out. </font>
		</c:if>
	</div>

	<div class="container w-25">
		<h1 align="center">Login</h1>

		<form action="${loginUrl}" method="POST">
			<div class="form-group">
				<label for="name">User Name</label> <input id="name"
					placeholder="Enter Username" name="name" required="required"
					type="text" maxlength="30" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input id="password"
					placeholder="Enter Password" name="password" required="required"
					type="password" maxlength="30" class="form-control" />
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<button id="login" type="submit"
				class="btn-primary btn-lg btn-block active">Login</button>
		</form>

		<button id="register" type="submit" class="btn btn-secondary"
			onclick="window.location.href='register'">Register</button>
	</div>
</body>
</html>