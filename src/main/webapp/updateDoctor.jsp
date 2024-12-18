<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/updateDoctor.css">
    <title>Update Doctor</title>
</head>
<body>
    <h2>Update Doctor Information</h2>
    <form action="updateDoctor" method="post">
        <h3>Personal Information</h3>
        
        <!-- Hidden field for doctor ID -->
        <input type="hidden" id="id" name="id" value="${doctor.id}">
        
        <label for="name">Name:</label> 
        <input type="text" id="name" name="name" value="${doctor.name}" required><br> 
        
        <label for="email">Email:</label> 
        <input type="email" id="email" name="email" value="${doctor.email}" required><br> 
        
        <label for="specialization">Specialization:</label> 
        <input type="text" id="specialization" name="specialization" value="${doctor.specialization}" required><br>
        
        <label for="phone">Phone:</label> 
        <input type="text" id="phone" name="phone" value="${doctor.phone}" required><br>
        
        <label for="address">Address:</label> 
        <input type="text" id="address" name="address" value="${doctor.address}" required><br>
        
        <label for="age">Age:</label> 
        <input type="number" id="age" name="age" value="${doctor.age}" required><br>
        
        <label for="bloodGroup">Blood Group:</label> 
        <input type="text" id="bloodGroup" name="bloodGroup" value="${doctor.bloodGroup}" required><br>
        
        <label for="password">Password:</label> 
        <input type="text" id="password" name="password" value="${doctor.password}" required><br>

        <input type="submit" value="Update">
        <a href="listDoctors" class="btn cancel">Cancel</a>
    </form>
</body>
</html>
