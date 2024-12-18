<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/AdminInfo1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Admin Page >> Admin Section</title>
<style>
    /* Assuming you might need a style for the close-button */
    .close-button {
        font-size: 24px;
        cursor: pointer;
        position: absolute;
        top: 10px;
        right: 10px;
    }
    #adminFormContainer {
        position: relative;
    }
</style>
</head>
<body>
	<section id="admin">
		<div class="heading">
			<h3>
				<i class="fa fa-user-circle-o"></i> Admin <i
					class="fa fa-angle-double-right"></i> Admin Section
			</h3>
		</div>
	</section>
	<section>
		<div class="hamburger-menu">
			<input type="checkbox" id="menu-toggle"> <label
				for="menu-toggle" class="menu-icon">&#9776;</label>
			<nav class="sidebar">
				<label for="menu-toggle" class="close-icon">&times;</label>
				<ul>
					<li><a href="home.html">Dashboard</a></li>
					<li><a href="home.html" class="new-user-link" id="logout">
							<i class="fa fa-sign-out"></i> Logout
					</a></li>
				</ul>
			</nav>
		</div>
	</section>

	<section id="division">
		<div id="box1" class="box">Admin List</div>
		<div id="box2" class="box">
			Add Admin
			<div id="plus_icon">
				<img src="images/plus1.png" alt="">
			</div>
		</div>
	</section>

	<div id="adminFormContainer" style="display: none;">
		<form action="addAdmin" id="adminForm" method="post">
			<span class="close-button" onclick="closeForm()">×</span>
			<h2>Admin Registration Form</h2>
			
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" required>
			
			<label for="email">Email:</label>
			<input type="email" id="email" name="email" required>
			
			<label for="qualification">Qualification:</label>
			<input type="text" id="qualification" name="qualification" required>
			
			<label for="phone">Phone:</label>
			<input type="tel" id="phone" name="phone" required>
			
			<label for="address">Address:</label>
			<input type="text" id="address" name="address" required>
			
			<label for="age">Age:</label>
			<input type="number" id="age" name="age" required>
			
			<label for="blood">Blood Group:</label>
			<input type="text" id="blood" name="blood" required>
			
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
			
			<button type="submit">Register</button>

			<p id="successMessage" style="display: none;">Registration successfully done</p>
		</form>
	</div>

	<script>
		document.getElementById("box1").onclick = function() {
			window.location.href = "listAdmins";
		};

		document.getElementById("box2").onclick = function() {
			document.getElementById("adminFormContainer").style.display = 'block';
		};

		document.getElementById("adminForm").onsubmit = function(event) {
			event.preventDefault(); // Prevent the default form submission

			// Display success message
			document.getElementById("successMessage").style.display = 'block';

			// Hide the success message after 10 seconds
			setTimeout(function() {
				document.getElementById("successMessage").style.display = 'none';
			}, 10000);

			// Optionally, you can submit the form via AJAX here, or use regular form submission
			this.submit(); // Uncomment this line if you want the form to actually submit after showing the message
		};

		function closeForm() {
			document.getElementById("adminFormContainer").style.display = 'none';
		}
	</script>

</body>

</html>
