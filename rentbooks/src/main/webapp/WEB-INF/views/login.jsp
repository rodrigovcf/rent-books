<%@page
	import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

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

		<form id="form" action="/login" method="POST">
			<div class="form-group">
				<label for="name">User Name</label> <input id="name"
					placeholder="Enter Username" name="name" type="text"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input id="password"
					placeholder="Enter Password" name="password" type="password"
					class="form-control" />
			</div>

			<button id="login" type="submit"
				class="btn-primary btn-lg btn-block active">Login</button>
		</form>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>

		<a class="btn btn-secondary" id="register" href="/register">Register</a>

	</div>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/validate.min.js"></script>
	<script src="/resources/js/validation-add.js"></script>
</body>
</html>