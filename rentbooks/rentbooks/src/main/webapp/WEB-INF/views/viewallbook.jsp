<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>View all book</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="View all book" />
	</jsp:include>

	<div class="container" align="center">

		<div id="error" class="alert alert-error" align="center">
			<c:if test="${empty books}">
				<p>
					<font color="red"> No data </font>
				</p>
			</c:if>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th><label>Book Id:</label></th>
					<th><label>Book Name:</label></th>
					<th><label>Price:</label></th>
					<th><sec:authorize access="hasRole('ADMIN')">
							<label>Available</label>
						</sec:authorize></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<% int contU = 0, contD = 0, contAvailables = 0; %>
				<c:forEach items="${books}" var="book">
					<tr>
						<sec:authorize access="hasRole('ADMIN')">
							<td>${book.id}</td>
							<td>${book.name}</td>
							<td>${book.price}</td>
							<td>${book.available}</td>

							<td><a class="btn btn-primary"
								href="update-book?id=${book.id}">Update<%out.print(++contU);%></a>
								<a class="btn btn-danger" href="delete-book?id=${book.id}">Delete<%out.print(++contD);%></a>
							</td>
						</sec:authorize>
						<sec:authorize access="hasRole('USER')">
							<c:if test="${book.available eq 'Y'.charAt(0)}">
								<td>${book.id}</td>
								<td>${book.name}</td>
								<td>${book.price}</td>
								<td><a class="btn btn-primary"
									href="renter-book?id=${book.id}">Rent_<%out.print(++contAvailables);%></a>
								</td>
							</c:if>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>