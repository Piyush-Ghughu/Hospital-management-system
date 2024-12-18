<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/PatientsList.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>List of Patients</title>
</head>
<body>
<section id="admin">
		<div class="heading">
		<h4>
			<i class="fa fa-user-circle-o"></i> Admin <i
				class="fa fa-angle-double-right"></i>Admin section <i
				class="fa fa-angle-double-right"></i>Patient List
			</h4>
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


<section id = "Patient-list">
<h2>List of Patients</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.id}</td>
            <td>${patient.name}</td>
            <td>${patient.email}</td>
            <td>${patient.password}</td>
            <td>
                <a href="updatePatient?id=${patient.id}">Edit</a> 
                <a href="deletePatient?id=${patient.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="AddPatient.jsp">Add New Patient</a>
</section>




</body>
</html>
