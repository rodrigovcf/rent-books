<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View All Book</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


	<div id="error" class="alert alert-error" align="center">
		<c:if test="${empty books}">
			<p>
				<font color="red">No book</font>
			</p>
		</c:if>
	</div>

	<h1 align="center">View book</h1>

	<nav class="navbar navbar-light bg-light justify-content-center">

		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>

			<li class="nav-item"><a class="nav-link" href="viewallbook">View
					All Task</a></li>

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
					<th><label>Book Id:</label></th>
					<th><label>Book Name:</label></th>
					<th><label>Price:</label></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
				int contU = 0, contD = 0, cont = 0;
				%>
				<c:forEach items="${books}" var="book">
					<tr>
						<c:if test="${book.available eq 'Y'.charAt(0)}">
							<%++cont;%>
							<td><label id="book_id<%out.print(cont);%>">${book.id}</label></td>
							<td><label id="book_name<%out.print(cont);%>">${book.name}</label></td>
							<td><label id="book_price<%out.print(cont);%>">${book.price}</label></td>
							<td><a class="btn btn-primary"
								href="renter-book?id=${book.id}">Rent_<%out.print(cont);%></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>