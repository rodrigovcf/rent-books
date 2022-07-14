<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Register</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div id="error" class="alert alert-error" align="center">
			<font color="red">${errorMessage}</font>
	</div>
	<div class="container w-25">
		<h1 align="center">Register</h1>

		<form:form id="form" modelAttribute="renter" action="register"
			method="POST">
			<div class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" maxlength="30" id="name" name="name"
					placeholder="Enter Username" type="text" 
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" maxlength="30" id="password" 
					name="password" placeholder="Enter Password" 
					type="password" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="cpassword">Confirm Password</form:label>
				<form:input path="cpassword" maxlength="30"
					id="cpassword" name="cpassword" 
					placeholder="Confirm your Password" type="password" 
					class="form-control" />
			</div>
			
			<button id="register" type="submit"
				class="btn-primary btn-lg btn-block active">Register</button>


		</form:form>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>

	</div>

	<script src="/resources/js/bootstrap.min.js"></script>
	
</body>
</html>