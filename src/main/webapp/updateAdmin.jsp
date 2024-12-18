<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/updateDoctor.css"> <!-- Updated stylesheet reference -->
    <title>Update Admin</title>
</head>
<body>
    <h2>Update Admin Information</h2>
    <form action="updateAdmin" method="post">
        <h3>Personal Information</h3>
        
        <!-- Hidden field for admin ID -->
        <input type="hidden" id="id" name="id" value="${admin.id}">
        
        <label for="name">Name:</label> 
        <input type="text" id="name" name="name" value="${admin.name}" required><br> 
        
        <label for="email">Email:</label> 
        <input type="email" id="email" name="email" value="${admin.email}" required><br> 
        
        <label for="qualification">Qualification:</label> 
        <input type="text" id="qualification" name="qualification" value="${admin.qualification}" required><br>
        
        <label for="phone">Phone:</label> 
        <input type="text" id="phone" name="phone" value="${admin.phone}" required><br>
        
        <label for="address">Address:</label> 
        <input type="text" id="address" name="address" value="${admin.address}" required><br>
        
        <label for="age">Age:</label> 
        <input type="number" id="age" name="age" value="${admin.age}" required><br>
        
        <label for="bloodGroup">Blood Group:</label> 
        <input type="text" id="bloodGroup" name="bloodGroup" value="${admin.bloodGroup}" required><br>
        
        <label for="password">Password:</label>
        <input type="text" id="password" name="password" value="${admin.password}"required>

        <input type="submit" value="Update">
        <a href="listAdmins" class="btn cancel">Cancel</a>
    </form>
</body>
</html>
