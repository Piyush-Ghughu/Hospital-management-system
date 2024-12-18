<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Patient Registration</title>
<link rel="stylesheet" href="css/registration.css">
</head>
<body>
	<h2>Patient Registration Form</h2>
	<form action="addPatient" method="post">
		<h3>Personal Information</h3>
		<label for="name">Name:</label> 
		<input type="text" id="name" name="name" required><br> 	
		<label for="email">Email:</label> 
		<input type="email" id="email" name="email" required><br> 
		<label for="password">Password:</label> 
		<input type="password" id="password"name="password" required><br>
		<input type="submit" value="Register">
	</form>
	<%
	if (session.getAttribute("successMsg") != null) {
	%>
	<p style="color: green;"><%=session.getAttribute("successMsg")%></p>
	<%
	session.removeAttribute("successMsg");
	%>
	<%
	} else if (session.getAttribute("errorMsg") != null) {
	%>
	<p style="color: red;"><%=session.getAttribute("errorMsg")%></p>
	<%
	session.removeAttribute("errorMsg");
	%>
	<%
	}
	%>
</body>
</html>