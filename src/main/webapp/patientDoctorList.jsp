<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/PatientDoctorList.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Patient Portal >> Doctor List</title>
</head>
<body>
	<section id="admin">
		<div class="heading">
			<h4>
				<i class="fa fa-user-circle-o"></i> Patient Portal<i class="fa fa-angle-double-right"></i>Doctor section
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

	<section id="patientlist">
    <h2>List of Doctors</h2>
    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Specialization</th>
                    <th>Phone</th>
                    <th>Appointment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doctor" items="${doctors}">
                    <tr>
                        <td>${doctor.name}</td>
                        <td>${doctor.specialization}</td>
                        <td>${doctor.phone}</td>
                        <td><button class="appointment-btn" onclick="requestAppointment(this)">Take Appointment</button></td>
                    </tr>
                    
                    
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<script>
    function requestAppointment(button) {
        button.textContent = "Request Sent";
        button.style.backgroundColor = "red";
        button.disabled = true; // Optional: Disable the button after the request
    }
</script>


</body>
</html>
