<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1 align="center">${param.title}</h1>
<nav class="navbar navbar-light bg-light justify-content-center">

	<ul class="nav">
		<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
			<li class="nav-item"><a class="nav-link" href="addbook">Add
					Book</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
			<li class="nav-item"><a class="nav-link" href="viewallbook">View
					All Book</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('USER')">
			<li class="nav-item"><a class="nav-link" href="status">Status</a>
			</li>
		</sec:authorize>
		<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
		</li>
	</ul>

</nav>

