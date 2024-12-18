<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/Doctorlist.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Doctor List</title>
</head>
<body>
    <section id="admin">
        <div class="heading">
            <h4>
                <i class="fa fa-user-circle-o"></i> Admin <i class="fa fa-angle-double-right"></i>Doctor section <i class="fa fa-angle-double-right"></i>Doctor List
            </h4>
        </div>
    </section>

    <section>
        <div class="hamburger-menu">
            <input type="checkbox" id="menu-toggle">
            <label for="menu-toggle" class="menu-icon">&#9776;</label>
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

    <section id="Alist">
        <h2>List of Doctors</h2>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Specialization</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Age</th>
                <th>Blood Group</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="doctor" items="${doctors}">
                <tr>
                    <td>${doctor.id}</td>
                    <td>${doctor.name}</td>
                    <td>${doctor.email}</td>
                    <td>${doctor.specialization}</td>
                    <td>${doctor.phone}</td>
                    <td>${doctor.address}</td>
                    <td>${doctor.age}</td>
                    <td>${doctor.bloodGroup}</td>
                    <td>${doctor.password}</td>
                    <td>
                        <a href="updateDoctor?id=${doctor.id}" class="edit-link">Edit</a>
                        <a href="deleteDoctor?id=${doctor.id}" class="delete-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="doctorInfo.html" class="add-new-doctor">Add New Doctor</a>
    </section>
</body>
</html>
