<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Status</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Book Status" />
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
					<th><label>Book ID</label></th>
					<th><label>RENTER ID</label></th>
					<th><label></label></th>
				</tr>
			</thead>

			<% int cont = 0; %>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${renter.id}</td>

					<td>
						<a class="btn btn-danger" 
							href="renter-delete?id=${book.id}">
								Delete_<%out.print(++cont); %>
						</a>
					</td>
			
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>