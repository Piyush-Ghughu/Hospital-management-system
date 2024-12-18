<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/doctorViewPatientAppointmentlist.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   
    <title>Doctor - View Appointments</title>
</head>
<body>
<section id="admin">
		<div class="heading">
		<h4>
			<i class="fa fa-user-circle-o"></i> Doctor  
			<i class="fa fa-angle-double-right"></i>Appointment List
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

    <h2>Patient Appointment List</h2>
    
    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>Patient Name</th>
                    <th>Patient Email</th>
                    <th>Appointment Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appointment" items="${appointments}">
                    <tr>
                        <td>${appointment.patient.name}</td>
                        <td>${appointment.patient.email}</td>
                        <td>${appointment.appointmentDate}</td>
                        <td>
                            <form action="manageAppointment" method="post">
                                <input type="hidden" name="appointmentId" value="${appointment.id}">
                                <button type="submit" name="action" value="approve">Accept</button>
                                <button type="submit" name="action" value="deny">Deny (Cancel)</button>
                                <button type="submit" name="action" value="delete">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>