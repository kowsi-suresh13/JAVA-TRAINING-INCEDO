<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Syllabus</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            display: flex;
            flex-direction: column;
            height: 100vh;
        }
        h2 {
            text-align: center;
            font-size: 24px;
            color: #333;
        }
        form {
            width: 100%;
            padding: 20px;
        }
        label {
            font-size: 16px;
            display: block;
            margin: 10px 0 5px;
        }
        textarea, input, select {
            width: calc(100% - 20px);
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .back-btn {
            background: #28a745;
            padding: 10px 20px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            cursor: pointer;
        }
        .add-btn {
            background-color: #D33A2C;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .add-btn:hover {
            background: darkred;
        }
    </style>
</head>
<body>

    <h2>Add Syllabus</h2>

    <!-- Success message -->
    <c:if test="${not empty message}">
        <p style="color: green; text-align: center;">${message}</p>
    </c:if>

    <!-- Full-page form -->
    <form action="${pageContext.request.contextPath}/${syllabus.course.courseid}/syllabus/add" method="post">
        
        <input type="hidden" name="courseId" value="${syllabus.course.courseid}">
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>

        <label for="duration">Duration (in Hours):</label>
        <input type="number" id="duration" name="duration" required>

        <label for="videoStatus">Video Completed:</label>
        <select id="videoStatus" name="videoStatus">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>

        <label for="status">Syllabus Status:</label>
        <select id="status" name="status">
            <option value="true">Active</option>
            <option value="false">Inactive</option>
        </select>

        <div class="button-container">
            <!-- Left Bottom: Back Button -->
            <a href="${pageContext.request.contextPath}/home" class="back-btn">Back to Home</a>
            
            <!-- Right Bottom: Add Button -->
            <button type="submit" class="add-btn">Add Syllabus</button>
        </div>
    </form>

</body>
</html>
