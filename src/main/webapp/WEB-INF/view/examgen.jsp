<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Secure Exam Generation </title>
</head>
<body>

	<h2> Exam generation functionality available to lecturers and students </h2>
	
	<form action = "examgenview" method = "GET">
		<input type = "text" name = "areaOfKnowledge" placeholder = " Enter your area of knowledge : "/>
		<input type = "submit"/>
	</form>
	
	<a href ="${pageContext.request.contextPath}/"> Back to Home Page </a> 
	
</body>
</html>