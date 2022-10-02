<html>
<head>

	<title>Secure Exam Generation </title>
</head>
<body>

	<h2> Question and answer functionality available to lecturers only </h2>
	
	<hr>
	
	<form action = "questionanswerview" method = "GET">
		<input type = "text" name = "lecturername" placeholder = "Enter your name: : "/>
		<input type = "text" name = "question" placeholder = " Enter question : "/>
		<input type = "text" name = "answer" placeholder = " Enter answer : "/>
		<input type = "text" name = "areaOfKnowledge" placeholder = " Enter your area of knowledge : "/>
		<input type = "submit"/>
	</form>
	
	<a href ="${pageContext.request.contextPath}/"> Back to Home Page </a> 
	
</body>
</html>