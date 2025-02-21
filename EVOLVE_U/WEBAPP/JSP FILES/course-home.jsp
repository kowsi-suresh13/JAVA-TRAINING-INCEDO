<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home - Course Management</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            background-color: #f7fbfc; /* Light blue background */
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
            font-size: 2.5em;
            margin-bottom: 40px;
            font-weight: bold;
        }

        .container {
            display: flex;
            justify-content: center;
            gap: 50px; /* Space between sections */
            margin-top: 50px;
        }

        .section {
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
            width: 320px; /* Adjusted width for better balance */
            display: flex;
            flex-direction: column;
            align-items: center;
            transition: transform 0.3s ease-in-out, box-shadow 0.3s ease;
            border: 1px solid #ddd; /* Light border around sections */
        }

        .section:hover {
            transform: scale(1.02); /* Slight hover effect for sections */
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
        }

        /* Button Styling */
        .button-17 {
            appearance: none;
            background-color: #74b9ff; /* Lighter blue color for buttons */
            border-radius: 24px;
            border: 1px solid #a6c8ff; /* Light border around buttons */
            color: white;
            cursor: pointer;
            font-size: 16px;
            font-weight: 500;
            height: 48px;
            padding: 12px 24px;
            text-align: center;
            text-decoration: none;
            width: 80%; /* Ensures button is centered */
            margin-top: 15px;
            transition: background-color 0.3s ease, box-shadow 0.2s ease, transform 0.2s ease;
        }

        .button-17:hover {
            background-color: #5d99cc; /* Slightly darker shade of blue on hover */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            transform: translateY(-2px); /* Slight lift effect */
        }

        .section-header {
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
        }

        /* Dashboard and SignOut Button Styling */
        .top-buttons {
            position: absolute;
            top: 20px;
            right: 20px;
            display: flex;
            gap: 15px;
        }

        .top-buttons button {
            background-color: #007BFF;
            border-radius: 24px;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            cursor: pointer;
            color: white;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .top-buttons button:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }

        /* Dropdown Menu for Dashboard */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 220px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 8px;
            margin-top: 8px;
            padding: 10px;
        }

        .dropdown-content a {
            color: #333;
            padding: 12px;
            text-decoration: none;
            display: block;
            font-size: 16px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .dropdown-content a:hover {
            background-color: #f0f0f0;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* Footer Section */
        footer {
            background-color: #007BFF;
            color: white;
            padding: 20px;
            text-align: center;
            border-radius: 8px;
            margin-top: 50px;
            font-size: 14px;
        }

    </style>
</head>
<body>

    <h1>Welcome to Course Management</h1>

    <!-- Top-right buttons (Dashboard, SignOut) -->
    <div class="top-buttons">
        <!-- Dashboard Button -->
        <div class="dropdown">
            <button id="dashboardBtn">Dashboard</button>
            <div class="dropdown-content" id="dashboardMenu">
                <a href="${pageContext.request.contextPath}/instructor/reports">View Reports</a>
                <a href="${pageContext.request.contextPath}/updateIns/${instructor.instructorId}">Update Profile</a>
                <a href="${pageContext.request.contextPath}/instructor/account/view">View Profile</a>
                <a href="${pageContext.request.contextPath}/instructor/account/reset-password">Reset Password</a>
                <a href="${pageContext.request.contextPath}/instructor/account/share">Share Profile</a>
            </div>
        </div>

        <!-- SignOut Button -->
        <button onclick="window.location.href='${pageContext.request.contextPath}/logout'">Sign Out</button>
    </div>

    <div class="container">
        
        <!-- Course Management Section -->
        <div class="section">
            <div class="section-header">Course Management</div>
            <a href="${pageContext.request.contextPath}/courses/add" class="button-17">Add Course</a>
            <a href="${pageContext.request.contextPath}/courses" class="button-17">View Courses</a>
            <a href="${pageContext.request.contextPath}/courses/update" class="button-17">Update Course</a>
            <a href="${pageContext.request.contextPath}/courses/delete" class="button-17">Delete Course</a>
        </div>

        <!-- Syllabus Management Section -->
        <div class="section">
            <div class="section-header">Syllabus Management</div>
            <a href="${pageContext.request.contextPath}/syllabus/ask" class="button-17">Add Syllabus</a>
            <a href="${pageContext.request.contextPath}/syllabus/update" class="button-17">Update Syllabus</a>
            <a href="${pageContext.request.contextPath}/syllabus/delete" class="button-17">Delete Syllabus</a>
        </div>

    </div>

    <footer>
        <p>&copy; 2025 Course Management System | All Rights Reserved</p>
    </footer>

</body>
</html>
