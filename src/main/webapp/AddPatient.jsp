<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>
</head>
<body>
<h1>Register here for patient:</h1>
	<form action="addPatient" method="post">
	<label>Name:</label><br>
	<input type="text" name = "name"><br><br>
	<label>Email:</label><br>
	<input type="email" name = "email"><br><br>
	<label>Password:</label><br>
	<input type="password" name = "password"><br><br>
	<input type="submit" value="Register">
	</form>
</body>
</html>