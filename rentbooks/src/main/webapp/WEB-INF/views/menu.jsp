<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>Menu</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
	
	<h1 align="center">${param.title}</h1>
	<nav class="navbar navbar-light bg-light justify-content-center">
	
  	<ul class="nav">
  		<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
  			<li class="nav-item">
			   <a class="nav-link" href="home">Home</a>
			</li>
		</sec:authorize> 
		<sec:authorize access="hasRole('ADMIN')">
			<li class="nav-item">
			   <a class="nav-link" href="addbook">Add Book</a>
			</li>
		</sec:authorize>
		<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
			<li class="nav-item">
			   <a class="nav-link" href="viewallbook">View All Book</a>
			</li>
		</sec:authorize>
		<sec:authorize access="hasRole('USER')">
			<li class="nav-item">
			   <a class="nav-link" href="status">Status</a>
			</li>
		</sec:authorize>
			<li class="nav-item">
			   <a class="nav-link" href="logout">Logout</a>
			</li>
	</ul>
  	 		
	</nav>
			
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>