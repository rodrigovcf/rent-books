<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<title>Register</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
	
	<div class="container w-25">
		<h1 align="center">Register</h1>
		<div id="error">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
		</div>
		
		<form:form id="form" action="register" method="POST" 
			commandName="renter">
			
			<div class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" id="name" 
					placeholder="Enter Username" 
					name="name" required="required" type="text" 
					maxlength="30" class="form-control"/> 
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" id="password" 
					placeholder="Enter Password" 
					name="password" required="required" 
					type="password"  maxlength="30" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label>Confirm Password</label>
				<input id="cpassword" 
					placeholder="Confirm your Password" 
					name="cpassword" required="required" 
					type="password"  maxlength="30" class="form-control"/>
			</div>
			
			<button id="register" type="submit" class="btn btn-primary">
				Register
			</button>
		</form:form>
		
		 <script> 
			 var password = document.getElementById("password")
			  , confirm_password = document.getElementById("cpassword");
	
			function validatePassword(){
			  if(password.value != confirm_password.value) {
			    confirm_password.setCustomValidity(
			    "Invalid format - password do not match with confirm password");
			  } else {
			    confirm_password.setCustomValidity('');
			  }
			}
	
			password.onchange = validatePassword;
			confirm_password.onkeyup = validatePassword;
		</script> 
		
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>