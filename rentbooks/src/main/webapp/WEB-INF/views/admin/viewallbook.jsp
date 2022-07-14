<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View all book</title>
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

	<h1 align="center">View all book</h1>

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

	<div class="container" align="center">


		<table class="table table-striped">
			<thead>
				<tr>
					<th><label>Book Id:</label></th>
					<th><label>Book Name:</label></th>
					<th><label>Price:</label></th>
					<th><label>Available</label></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
				int contU = 0, contD = 0, cont = 0;
				%>
				<c:forEach items="${books}" var="book">
					<tr>
						<%++cont;%>
						<td><label id="bookid_<%out.print(cont);%>">${book.id}</label></td>
						<td><label id="name_<%out.print(cont);%>">${book.name}</label></td>
						<td><label id="price_<%out.print(cont);%>">${book.price}</label></td>
						<td><label id="avail_<%out.print(cont);%>">${book.available}</label></td>

						<td><a class="btn btn-primary"
							href="update-book?id=${book.id}">Update<%out.print(++contU);%></a>
							<a class="btn btn-danger" href="delete-book?id=${book.id}">Delete<%out.print(++contD);%></a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>