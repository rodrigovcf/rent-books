<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<sec:authorize access="hasRole('ADMIN')">
	<jsp:include page="../menu.jsp">
		<jsp:param name="title" value="View all book" />
	</jsp:include>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
	<jsp:include page="../menu.jsp">
		<jsp:param name="title" value="View all book" />
	</jsp:include>
</sec:authorize>
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
	<h1>TESTANDOOOOOOOOOOO</h1>
	<div class="container" align="center">


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
				<%
				int contU = 0, contD = 0, cont = 0;
				%>
				<c:forEach items="${books}" var="book">
					<tr>
						<sec:authorize access="hasRole('ADMIN')">
							<%
							++cont;
							%>
							<td><label id="bookid_<%out.print(cont);%>">${book.id}</label></td>
							<td><label id="name_<%out.print(cont);%>">${book.name}</label></td>
							<td><label id="price_<%out.print(cont);%>">${book.price}</label></td>
							<td><label id="avail_<%out.print(cont);%>">${book.available}</label></td>

							<td><a class="btn btn-primary"
								href="update-book?id=${book.id}">Update<%out.print(++contU);%></a>
								<a class="btn btn-danger" href="delete-book?id=${book.id}">Delete<%out.print(++contD);%></a>
							</td>
						</sec:authorize>
						<sec:authorize access="hasRole('USER')">
							<c:if test="${book.available eq 'Y'.charAt(0)}">
								<%
								++cont;
								%>
								<td><label id="book_id<%out.print(cont);%>">${book.id}</label></td>
								<td><label id="book_name<%out.print(cont);%>">${book.name}</label></td>
								<td><label id="book_price<%out.print(cont);%>">${book.price}</label></td>
								<td><a class="btn btn-primary"
									href="renter-book?id=${book.id}">Rent_<%out.print(cont);%></a></td>
							</c:if>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>