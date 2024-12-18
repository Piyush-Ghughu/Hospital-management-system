<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminlist.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Admin List >> Admin List</title>
</head>
<body>
    <section id="admin">
        <div class="heading">
            <h4><i class="fa fa-user-circle-o"></i> Admin <i class="fa fa-angle-double-right"></i> Admin Section <i class="fa fa-angle-double-right"></i> Admin List</h4>
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
        <h2>Admin List</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>QUALIFICATION</th>
                    <th>PHONE</th>
                    <th>ADDRESS</th>
                    <th>AGE</th>
                    <th>BLLOOD GROUP</th>
                    <th>PASSWORD</th>
                    <th>ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="admin" items="${admins}">
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.name}</td>
                        <td>${admin.email}</td>
                        <td>${admin.qualification}</td>
                        <td>${admin.phone}</td>
                        <td>${admin.address}</td>
                        <td>${admin.age}</td>
                        <td>${admin.bloodGroup}</td>
                        <td>${admin.password}</td>
                        <td>
                        <a href="updateAdmin?id=${admin.id}" class="edit-link">Edit</a>
                        <a href="deleteAdmin?id=${admin.id}" class="delete-link">Delete</a>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <a href="adminInfo.html" class="add-new-doctor">Add New Doctor</a>
    </section>
</body>
</html>
