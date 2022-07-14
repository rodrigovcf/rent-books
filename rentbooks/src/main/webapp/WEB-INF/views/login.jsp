<%@page
	import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<div id="error" class="alert alert-error" align="center">
		<font color="red">${errorMessage}</font>
	</div>

	<div class="container w-25">
		<h1 align="center">Login</h1>

		<form:form id="form" modelAttribute="user" action="login"
			method="POST">
			<div class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" maxlength="30" id="name" name="name"
					placeholder="Enter Username" type="text" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" maxlength="30" id="password"
					name="password" placeholder="Enter Password" type="password"
					class="form-control" />
			</div>

			<button id="login" type="submit"
				class="btn-primary btn-lg btn-block active">Login</button>


		</form:form>

		<button class="btn btn-secondary" id="register"
			onclick="window.location.href='register'">Register</button>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>

	</div>
	<script src="/resources/js/validate.min.js"></script>
</body>
</html>