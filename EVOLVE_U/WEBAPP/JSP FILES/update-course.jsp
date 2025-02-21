<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Update Course</title>
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
            background-color: #007bff; /* Blue for "Update Course" */
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
            background-color: #0056b3;
        }
        .back-btn {
            background-color: #dc3545; /* Red for "Back to Home" */
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
            background-color: #b02a37;
        }
    </style>
</head>
<body>

    <h2>Update Course</h2>

    <%-- Display Success or Error Messages --%>
    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>

    <%-- Ensure course object is present before rendering the form --%>
    <c:if test="${not empty course}">
        <form action="<c:url value='/courses/update/${course.courseid}' />" method="post">
            <input type="hidden" name="id" value="${course.courseid}">

            <label for="courseCode">Course Code:</label>
            <input type="text" id="courseCode" name="courseCode" value="${course.courseCode}" required>

            <label for="name">Course Name:</label>
            <input type="text" id="name" name="name" value="${course.name}" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${course.description}</textarea>

            <label for="duration">Duration (in days):</label>
            <input type="number" id="duration" name="duration" value="${course.duration}" required>

            <label for="syllabus">Syllabus (Number of Topics):</label>
            <input type="number" id="syllabus" name="syllabus" value="${course.syllabus}" required>

            <label for="price">Price ($):</label>
            <input type="number" step="0.01" id="price" name="price" value="${course.price}" required>

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
            <select id="paymentMode" name="paymentMode" required>
                <option value="Credit Card" ${course.paymentMode == 'Credit Card' ? 'selected' : ''}>Credit Card</option>
                <option value="Debit Card" ${course.paymentMode == 'Debit Card' ? 'selected' : ''}>Debit Card</option>
                <option value="PayPal" ${course.paymentMode == 'PayPal' ? 'selected' : ''}>PayPal</option>
                <option value="Bank Transfer" ${course.paymentMode == 'Bank Transfer' ? 'selected' : ''}>Bank Transfer</option>
            </select>
			<button type="submit" class="button-81">Update Course</button>
        </form>
    </c:if>

    <c:if test="${empty course}">
        <p style="color: red;">Error: Course details not found!</p>
    </c:if>

    

    <a href="<c:url value='/home' />" class="back-btn">Back to Home</a>

</body>
</html>
