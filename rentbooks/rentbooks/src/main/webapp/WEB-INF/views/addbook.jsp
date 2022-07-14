<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Add Book" />
	</jsp:include>

	<div id="error" class="alert alert-error" align="center">
		<font color="red">${errorMessage}</font>
	</div>

	<div class="container w-25">

		<form:form action="addbook" method="POST" commandName="book">
			<div class="form-group">
				<form:label path="name">Book Name</form:label>
				<form:input path="name" id="name" name="name" 
					class="form-control"
					required="required" type="text" />
			</div>
			<div class="form-group">
				<form:label path="price">Rent Price</form:label>
				<form:input path="price" id="price" name="price"
					class="form-control" min="1" required="required" 
					type="number" />
			</div>

			<button id="add" name="add" type="submit" class="btn btn-primary">Add</button>
		</form:form>

	</div>

</body>
</html>