<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        /* Body Style - Removing background gradient */
        body {
            font-family: Arial, sans-serif;
            background-color: #fff; /* Clean white background */
            margin: 0;
            padding: 0;
        }

        /* Header Style - Dark Blue Background */
        header {
            background-color: #1a2a6c; /* Dark Blue */
            color: white;
            text-align: center;
            padding: 15px 0;
            border-bottom: 2px solid #ddd;
        }

        .container {
            width: 80%;
            margin: 20px auto;
        }

        /* Section Style - Pastel Purple Containers */
        .section {
            margin-bottom: 30px;
            background-color: #d1c2e3; /* Pastel purple */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Section Headers */
        .section h2 {
            color: #4a90e2; /* Pastel blue for headers */
            font-size: 1.8rem;
            margin-bottom: 15px;
        }

        /* List Group */
        .list-group {
            list-style-type: none;
            padding: 0;
        }

        .list-group li {
            background-color: #f1f9fb; /* Light pastel blue */
            margin: 10px 0;
            padding: 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .list-group li:hover {
            background-color: #e0f4ff; /* Lighter hover effect */
        }

        /* Button Style */
        .action-button {
            background-color: #a2c2e8; /* Pastel blue */
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            width: 100%;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .action-button:hover {
            background-color: #4a90e2; /* Slightly darker blue on hover */
        }

        /* Footer Style */
        footer {
            text-align: center;
            background-color: #f9e6a0; /* Pastel yellow */
            color: #333;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>

<body>

    <header>
        <h1>Welcome to Your Dashboard</h1>
    </header>

    <div class="container">
        <!-- Home Page Section -->
        <div class="section">
            <h2>Explore Courses</h2>
            <ul class="list-group">
                <li onclick="location.href='/courses'">Explore Courses</li>
                <!-- Removed unwanted buttons here -->
            </ul>
        </div>

        <!-- Dashboard Section -->
        <div class="section">
            <h2>Dashboard</h2>
            <ul class="list-group">
                <li onclick="location.href='/ongoingCourses'">Ongoing Courses</li>
                <li onclick="location.href='/completedCourses'">Completed Courses</li>
                <li onclick="location.href='/certificatesBadges'">Certification and Badges</li>
            </ul>
        </div>

        <!-- Profile Settings Section -->
        <div class="section">
            <h2>Profile Settings</h2>
            <ul class="list-group">
                <li onclick="location.href='/update/${userId}'">Update Profile (Name, Email, Banking, Phone)</li>
                <li onclick="location.href='/profile'">View Profile</li>
                <li onclick="location.href='/resetPassword'">Reset Password</li>
            </ul>
        </div>

        <!-- Sign Out Section -->
        <div class="section">
            <button class="action-button" onclick="location.href='/logout'">Sign Out</button>
        </div>
    </div>

    <footer>
        <!-- Copyright text has been removed -->
    </footer>

</body>

</html>
