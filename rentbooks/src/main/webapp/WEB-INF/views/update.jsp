<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Update Book</title>
</head>
<body>

	<jsp:include page="menu.jsp">
		<jsp:param name="title" value="Update Book" />
	</jsp:include>
	
	<div class="container w-25">
		<div id="error" align="center">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
		</div>
		
		<form:form method="POST" commandName="book">
			<div class="form-group">
				<form:hidden path="id"/>
				<%-- <form:label path="id">ID:</form:label>
				<form:input id="id" path="id" required="required" 
					class="form-control" type="text" /> --%>
				<form:label path="name">Book Name:</form:label>
				<form:input id="name" path="name" required="required" 
					class="form-control" type="text" /> 
			</div>
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:input id="price" path="price" required="required" 
					class="form-control" type="text" />
			</div>
			<div class="form-group">
				<form:label path="available">Available:</form:label>
				<form:input id="available" path="available" 
					class="form-control" required="required" type="text" 
					maxlength="1"/>
			</div>
			<button id="update" type="submit" class="btn btn-primary">
				Submit
			</button>
		</form:form>
	</div>


</body>
</html>