<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/updateDoctor.css">
    <title>Update Patient</title>
  
</head>
<body>

<h2>Update Patient Details</h2>

<form action="updatePatient" method="post">
    <input type="hidden" name="id" value="${patient.id}" />

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${patient.name}" required /><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${patient.email}" required /><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${patient.password}" required /><br><br>

    <input type="submit" value="Update Patient" />
     <a href="listPatients" class="btn cancel">Cancel</a>
</form>



</body>
</html>
