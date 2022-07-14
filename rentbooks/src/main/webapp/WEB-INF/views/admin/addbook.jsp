<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div id="error" class="alert alert-error" align="center">
		<font color="red">${errorMessage}</font>
	</div>

	<h1 align="center">Add Book</h1>

	<nav class="navbar navbar-light bg-light justify-content-center">

		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>

			<li class="nav-item"><a class="nav-link" href="addbook">Add
					Book</a></li>

			<li class="nav-item"><a class="nav-link" href="viewallbook">View
					All Book</a></li>

			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>

	</nav>

	<div class="container w-25">

		<form:form id="form" action="addbook" method="POST" commandName="book">
			<div class="form-group">
				<form:label path="name">Book Name</form:label>
				<form:input path="name" id="name" name="name" class="form-control"
					type="text" />
			</div>
			<div class="form-group">
				<form:label path="price">Rent Price</form:label>
				<form:input path="price" id="price" name="price"
					class="form-control" type="text" />
			</div>

			<button id="add" name="add" type="submit" class="btn btn-primary">Add</button>
		</form:form>

		<script src="/resources/js/utilities.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>

	</div>


</body>
</html>