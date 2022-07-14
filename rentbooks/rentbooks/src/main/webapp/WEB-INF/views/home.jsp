<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<sec:authorize access="hasRole('ADMIN')">
	<title>Home</title>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
	<title>Renter Home</title>
</sec:authorize>

<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<sec:authorize access="hasRole('ADMIN')">
		<jsp:include page="menu.jsp">
			<jsp:param name="title" value="Owner Home" />
		</jsp:include>
	</sec:authorize>

	<sec:authorize access="hasRole('USER')">
		<jsp:include page="menu.jsp">
			<jsp:param name="title" value="Renter Home" />
		</jsp:include>
	</sec:authorize>

	<script src="/js/jquery-3.5.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>