<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>

<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	
	<div id="error" class="alert alert-error" align="center"></div>
	
	<h1 align="center">Renter Home</h1>
	
	<nav class="navbar navbar-light bg-light justify-content-center">

		<ul class="nav">
			<li class="nav-item">
				<a class="nav-link" href="home">Home</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="viewallbook">View All Book</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="status">Status</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>

	</nav>

</body>
</html>