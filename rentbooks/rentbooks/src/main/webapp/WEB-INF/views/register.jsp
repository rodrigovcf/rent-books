<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Register</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


	<div class="container w-25">
		<h1 align="center">Register</h1>
		<div id="error" align="center"></div>

		<form:form id="form" action="register" method="POST"
			commandName="renter">

			<div class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" id="name" placeholder="Enter Username"
					name="name" required="required" type="text" maxlength="30"
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" id="password"
					placeholder="Enter Password" name="password" required="required"
					type="password" maxlength="30" class="form-control" />
			</div>

			<div class="form-group">
				<label>Confirm Password</label> <input id="cpassword"
					placeholder="Confirm your Password" name="cpassword"
					required="required" type="password" maxlength="30"
					class="form-control" />
			</div>

			<button id="register" type="submit" class="btn btn-primary">
				Register</button>
		</form:form>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>
		
		<script>
		$(document).ready(function () {
			   $("#cpassword").on('keyup', function(){
			    var password = $("#password").val();
			    var confirmPassword = $("#cpassword").val();
			    var button = $("#register");
			    
			    if (password != confirmPassword){
			        $("#error").html("Invalid format - password do not match with confirm password").css("color","red");
			    	button.prop('disabled', true);
			    }
			    else{
			        $("#error").html("Password match !").css("color","green");
			        button.prop('disabled', false);} 
			   });
			});
		</script>
		

	</div>
</body>
</html>