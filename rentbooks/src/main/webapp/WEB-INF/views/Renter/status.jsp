<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Status</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div id="error" class="alert alert-error" align="center">
		<c:if test="${empty books}">
				<font color="red"> No data </font>
		</c:if>
	</div>
	
	<h1 align="center">Book Status</h1>

	<nav class="navbar navbar-light bg-light justify-content-center">

		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>

			<li class="nav-item"><a class="nav-link" href="viewallbook">View
					All Book</a></li>

			<li class="nav-item"><a class="nav-link" href="status">Status</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>

	</nav>
	<div class="container" align="center">

		<table class="table table-striped">

			<thead>
				<tr>
					<th><label>Book ID</label></th>
					<th><label>RENTER ID</label></th>
					<th><label></label></th>
				</tr>
			</thead>

			<% int contB = 0; %>
			<% int contR = 0; %>
			<% int contL = 0; %>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><label id="book_id<%out.print(++contB); %>">${book.id}</label></td>
					<td><label id="renter_id<%out.print(++contR); %>">${renter.id}</label></td>

					<td><a class="btn btn-danger"
						href="renter-delete?id=${book.id}"> Delete_<%out.print(++contL); %>
					</a></td>

				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>