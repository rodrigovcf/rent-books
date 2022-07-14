<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Book</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<div id="error" align="center">
		<p>
			<font color="red">${errorMessage}</font>
		</p>
	</div>

	<h1 align="center">Update Book</h1>
	
	<nav class="navbar navbar-light bg-light justify-content-center">

		<ul class="nav">
			<li class="nav-item">
				<a class="nav-link" href="home">Home</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="addbook">Add Book</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="viewallbook">View All Book</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>

	</nav>


	<div class="container w-25">

		<form:form method="POST" commandName="book">
			<div class="form-group">
				<form:hidden path="id" />
				<form:label path="name">Book Name:</form:label>
				<form:input id="name" name="name" path="name" required="required"
					class="form-control" type="text" />
			</div>
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:input id="price" name="price" path="price" required="required"
					class="form-control" type="text" />
			</div>
			<div class="form-group">
				<form:label path="available">Available:</form:label>
				<form:input id="available" name="available" path="available" class="form-control"
					required="required" type="text" maxlength="1" />
			</div>
			<form:button id="update" name="update" type="submit" class="btn btn-primary">
				Submit</form:button>
		</form:form>
	</div>


</body>
</html>