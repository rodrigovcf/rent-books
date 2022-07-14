<html>
<head>
<title>Home</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	
	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	
	<div class="container" align="center">Olá ${name}</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>