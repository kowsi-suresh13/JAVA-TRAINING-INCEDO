<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; background-color: #f1f1f1; }
        h1 { color: #333; }
        .container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 50%; margin: auto; }
        label { display: block; font-weight: bold; margin-top: 10px; }
        input, button { width: 100%; padding: 10px; margin-top: 5px; border-radius: 5px; border: 1px solid #ccc; }
        button { background-color: #28a745; color: white; font-size: 16px; cursor: pointer; }
        button:hover { background-color: #218838; }
        a { text-decoration: none; color: #007bff; font-weight: bold; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update User</h1>
        
        <%-- Display error message if any --%>
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>
        
			<form action="/update/${user.userId}" method="POST">
 
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${user.name}" required>
 
            <label for="emailId">Email:</label>
            <input type="emailId" id="emailId" name="emailId" value="${user.emailId}" required>
 
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required>
 
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" required>
 
            <label for="school">Education:</label>
            <input type="text" id="school" name="school" value="${user.school}" required>
 
            <button type="submit">Update User</button>
        </form>
 
        <br>
        <a href="/user-list">Back to Users List</a>
    </div>
</body>
</html>