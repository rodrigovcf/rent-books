<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Register</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div id="error" class="alert alert-error" align="center"></div>
	<div class="container w-25">
		<h1 align="center">Register</h1>


		<form:form id="form" action="register" method="POST"
			commandName="renter">

			<div class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" id="name" placeholder="Enter Username"
					name="name" required="true" type="text" 
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" id="password"
					placeholder="Enter Password" name="password" required="true"
					type="password"  class="form-control" />
			</div>

			<div class="form-group">
				<label>Confirm Password</label> <input id="cpassword"
					placeholder="Confirm your Password" name="cpassword" required
					type="text"  class="form-control" />
			</div>

			<form:button id="register" type="submit" class="btn btn-primary">
				Register</form:button>
		</form:form>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>

	</div>

	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/validate.min.js"></script>
	<script src="/resources/js/validation-register.js"></script>
</body>
</html>