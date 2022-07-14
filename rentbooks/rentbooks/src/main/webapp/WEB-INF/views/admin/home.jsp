<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<sec:authorize access="hasRole('ADMIN')">
	<title>Home</title>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
	<title>Home</title>
</sec:authorize>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	
	<div id="error" class="alert alert-error" align="center"></div>
	
	<sec:authorize access="hasRole('ADMIN')">
		<jsp:include page="../menu.jsp">
			<jsp:param name="title" value="Book Owner Home" />
		</jsp:include>
	</sec:authorize>

	<sec:authorize access="hasRole('USER')">
		<jsp:include page="../menu.jsp">
			<jsp:param name="title" value="Rent's Home" />
		</jsp:include>
	</sec:authorize>

	<h1>TESTANDOOOOOOOOOOO</h1>
</body>
</html>