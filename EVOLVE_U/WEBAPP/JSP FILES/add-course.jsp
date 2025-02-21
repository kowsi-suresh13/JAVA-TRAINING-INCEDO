<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
    <style> 
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 0;
            padding: 20px;
        }
        h2 {
            margin-bottom: 20px;
        }
        form {
            width: 50%;
            margin: auto;
            text-align: left;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
        }
        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .button-81 {
            background-color: #28a745; /* Green for "Add Course" */
            border: 0 solid #e2e8f0;
            border-radius: 1.5rem;
            color: white;
            cursor: pointer;
            font-size: 1rem;
            font-weight: 600;
            padding: 10px 20px;
            text-align: center;
            transition: all .1s ease-in-out;
            box-shadow: 0px 1px 2px rgba(166, 175, 195, 0.25);
            position: fixed;
            bottom: 20px;
            right: 20px;
        }
        .button-81:hover {
            background-color: #1e293b;
        }
        .back-btn {
            background-color: #007bff; /* Light Blue for "Back to Home" */
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 1.5rem;
            color: white;
            font-size: 1rem;
            font-weight: bold;
            position: fixed;
            bottom: 20px;
            left: 20px;
            transition: all 0.2s ease-in-out;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h2>Add New Course</h2>

    <!-- Show success or error message -->
    <% String message = (String) request.getAttribute("message");
       if (message != null) { %>
       <p style="color: green; font-weight: bold;"><%= message %></p>
    <% } %>

    <form action="/courses/add" method="POST">
        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" value="${course.name}" required>

        <label for="courseCode">Course Code:</label>
        <input type="text" id="courseCode" name="courseCode" value="${course.courseCode}" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${course.description}</textarea>

        <label for="duration">Duration:</label>
        <input type="text" id="duration" name="duration" value="" required>

        <label for="syllabus">Syllabus (Number of Topics):</label>
        <input type="number" id="syllabus" name="syllabus" value="" required>

        <label for="price">Price ($):</label>
        <input type="number" step="0.01" id="price" name="price" value="" required>

        <label for="syllabusStatus">Syllabus Status:</label>
        <select id="syllabusStatus" name="syllabusStatus">
            <option value="true" ${course.syllabusStatus ? "selected" : ""}>Completed</option>
            <option value="false" ${!course.syllabusStatus ? "selected" : ""}>Pending</option>
        </select>

        <label for="status">Course Status:</label>
        <select id="status" name="status">
            <option value="true" ${course.status ? "selected" : ""}>Active</option>
            <option value="false" ${!course.status ? "selected" : ""}>Inactive</option>
        </select>

        <label for="paymentMode">Payment Mode:</label>
        <select id="paymentMode" name="paymentMode">
            <option value="Paid" ${course.paymentMode.equals('Credit Card / Debit Card / UPI') ? 'selected' : ''}>Credit Card / Debit Card / UPI</option>
            <option value="Free" ${course.paymentMode.equals('Free') ? 'selected' : ''}>Free</option>
        </select>
		<button type="submit" class="button-81">Add Course</button>
    </form>

    

    <a href="${pageContext.request.contextPath}/home" class="back-btn">Back to Home</a>

</body>
</html>
