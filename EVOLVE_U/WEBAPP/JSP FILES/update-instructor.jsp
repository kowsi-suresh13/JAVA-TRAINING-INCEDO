update-instructor.jsp <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Instructor</title>
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
        <h1>Update Instructor</h1>
 
        <%-- Display error message if any --%>
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>
 
        <form action="/updateIns/${instructor.instructorId}" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${instructor.name}" required>
 
            <label for="emailId">Email:</label>
            <input type="email" id="emailId" name="emailId" value="${instructor.emailId}" required>
 
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"
                   value="<c:if test='${not empty instructor.password}'>${instructor.password}</c:if>">
 
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${instructor.phoneNumber}" required>
 
            <label for="qualification">Qualification:</label>
            <input type="text" id="qualification" name="qualification" value="${instructor.qualification}" required>
 
            <label for="workExperience">Work Experience:</label>
            <input type="number" id="workExperience" name="workExperience" value="${instructor.workExperience}" required>
 
            <label for="achievement">Achievement:</label>
            <input type="text" id="achievement" name="achievement" value="${instructor.achievement}" required>
 
            <button type="submit">Update Instructor</button>
        </form>
    </div>
</body>
</html>