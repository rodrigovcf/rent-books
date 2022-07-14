<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Status</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Book Status" />
	</jsp:include>

	<div id="error" class="alert alert-error" align="center">
		<c:if test="${empty books}">
			<p>
				<font color="red"> No data </font>
			</p>
		</c:if>
	</div>

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