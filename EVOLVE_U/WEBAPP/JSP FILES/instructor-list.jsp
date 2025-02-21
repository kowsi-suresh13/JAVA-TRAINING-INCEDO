instructor-list.jsp <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instructor List and Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffebde; /* Lighter shade of #ffc09f */
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin: 20px auto;
        }
        .form-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .form-container button {
            background-color: #ffc09f;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-weight: bold;
        }
        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #ffc09f;
            color: black;
        }
        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
        }
        .update-btn {
            background-color: #34eb9b;
            color: white;
            border: none;
            padding: 8px 12px;
            border-radius: 5px;
            cursor: pointer;
        }
        .delete-btn {
            background-color: #f01842;
            color: white;
            border: none;
            padding: 8px 12px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Instructor List</h1>
 
    <div class="alert">
        ${message != null ? message : ""}
    </div>
 
    <div class="form-container">
        <form action="/submitInstructor" method="POST">
            <h2>Add Instructor</h2>
			
			<label for="instructorId">Instructor Id:</label>
			<input type="text" id="instructorId" name="instructorId" required>
 
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
 
            <label for="emailId">Email ID:</label>
            <input type="email" id="emailId" name="emailId" required>
 
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
 
            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{10}$" title="Please enter a valid phone number" required>
 
            <label for="qualification">Qualification:</label>
            <input type="text" id="qualification" name="qualification" required>
 
            <label for="workExperience">Work Experience:</label>
            <input type="text" id="workExperience" name="workExperience" required>
 
            <label for="achievement">Achievement:</label>
            <input type="text" id="achievement" name="achievement" required>
 
            <button type="submit">Add Instructor</button>
        </form>
    </div>
 
    <h2>Instructor Details</h2>
    <table>
        <thead>
            <tr>
                <th>Instructor ID</th>
                <th>Name</th>
                <th>Email ID</th>
                <th>Password</th>
                <th>Phone Number</th>
                <th>Qualification</th>
                <th>Work Experience</th>
                <th>Achievement</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="instructor" items="${instructors}">
                <tr>
                    <td>${instructor.getInstructorId()}</td>
                    <td>${instructor.getName()}</td>
                    <td>${instructor.getEmailId()}</td>
                    <td>${instructor.getPassword()}</td>
                    <td>${instructor.getPhoneNumber()}</td>
                    <td>${instructor.getQualification()}</td>
                    <td>${instructor.getWorkExperience()}</td>
                    <td>${instructor.getAchievement()}</td>
                    <td class="action-buttons">
                        <a href="/updateIns/${instructor.instructorId}">
                            <button type="button" class="update-btn">Update</button>
                        </a>
                        <a href="/deleteIns/${instructor.instructorId}" onclick="return confirm('Are you sure you want to delete this instructor?')">
                            <button type="button" class="delete-btn">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>