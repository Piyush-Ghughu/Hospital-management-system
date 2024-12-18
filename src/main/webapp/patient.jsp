<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/user.css">
<title>User Login</title>
</head>
<body>
	<section>
		<div class="hamburger-menu">
			<input type="checkbox" id="menu-toggle"> <label
				for="menu-toggle" class="menu-icon">&#9776;</label>
			<nav class="sidebar">
				<label for="menu-toggle" class="close-icon">&times;</label>
				<ul>
					<li><a href="home.html">Dashboard</a></li>
					<!-- Changed to home.jsp -->
					<li><a href="register.jsp" class="new-user-link">New User</a></li>
				</ul>
			</nav>
		</div>
	</section>
	<div class="login-container">
		<h1>USER LOGIN</h1>
		<form action="patientLogin" method="post">
			<label for="email">Email</label><br> <input type="email"
				name="email" required placeholder="Enter your email"><br>
			<br> <label for="password">Password</label><br> <input
				type="password" name="password" required
				placeholder="Enter your password"><br>
			<br> <input type="submit" value="Login">
			<div id="error-message" class="error-message">
				<%-- Display error message if any --%>
				<c:if test="${not empty errorMessage}">
					<p>${errorMessage}</p>
				</c:if>
			</div>
			<!-- Error message container -->
		</form>
	</div>
</body>
</html>
