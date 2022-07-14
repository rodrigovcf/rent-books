<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Add Book" />
	</jsp:include>

	<div class="container w-25">

		<div id="error">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
		</div>

		<form:form action="addbook" method="POST" commandName="book">
			<div class="form-group">
				<form:label path="name">Book Name</form:label>
				<form:input path="name" id="name" class="form-control"
					required="required" type="text" />
			</div>
			<div class="form-group">
				<form:label path="price">Rent Price</form:label>
				<form:input path="price" id="price" class="form-control"
					required="required" type="text" />
			</div>

			<button id="add" type="submit" class="btn btn-primary">Add</button>
		</form:form>

	</div>

	<script src="/js/jquery-3.5.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>

</body>
</html>