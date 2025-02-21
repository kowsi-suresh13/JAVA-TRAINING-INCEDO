<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #fbcfe8, #d1d4f1, #f3d9f9, #d1e8e4); /* Pastel gradient */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-attachment: fixed;
            overflow: hidden;
        }

        /* Add pastel EvolveU text in the background */
        .background-pattern {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: 15rem;
            font-weight: bold;
            color: rgba(255, 255, 255, 0.2); /* White with low opacity */
            z-index: -1;
            text-transform: uppercase;
            letter-spacing: 5px;
            text-shadow: 4px 4px 12px rgba(255, 255, 255, 0.5);
        }

        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
            width: 100%;
            position: relative;
        }

        h2 {
            color: #333;
            font-size: 24px;
        }

        p {
            font-size: 16px;
            color: #555;
        }

        /* Button Styles */
        .button-33 {
            background-color: #a7c7f0;
            color: white;
            border-radius: 50px;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            display: inline-block;
            transition: all 0.3s ease;
            text-align: center;
            margin-top: 10px;
        }

        .button-33:hover {
            background-color: #8da9e1;
            transform: scale(1.05);
        }

        .register-button {
            background-color: #a5d8a5;
            padding: 12px 24px;
            color: white;
            border-radius: 50px;
            font-size: 18px;
            font-weight: bold;
            transition: all 0.3s ease;
            cursor: pointer;
            display: inline-block;
            text-align: center;
            position: absolute;
            bottom: 20px;
            right: 20px;
        }

        .register-button:hover {
            background-color: #8fc98f;
            transform: scale(1.05);
        }

        /* Syllabus section styling */
        .syllabus { margin-top: 20px; padding: 10px; border-top: 2px solid #007bff; }
        .syllabus-item { background: #f9f9f9; padding: 10px; border-radius: 5px; margin-bottom: 10px; }
    </style>
</head>
<body>
    <div class="background-pattern">EvolveU</div> <!-- EvolveU in pastel-colored text -->

    <div class="container">
        <h2>Course Details</h2>
        <p><strong>ID:</strong> ${course.getCourseCode()}</p>
        <p><strong>Name:</strong> ${course.getName()}</p>
        <p><strong>Description:</strong> ${course.getDescription()}</p>
        <p><strong>Syllabus:</strong> ${course.getSyllabus()}</p>
        <p><strong>Duration:</strong> ${course.getDuration()} hours</p>
        <p><strong>Price:</strong> $${course.getPrice()}</p>
        <p><strong>Payment Mode:</strong> ${course.getPaymentMode()}</p>
        
        <!-- View Syllabus and Back to Courses Buttons -->
        <button class="button-33" onclick="window.location.href='${pageContext.request.contextPath}/${course.getCourseid()}/syllabus'">View Syllabus</button>
        <button class="button-33" onclick="window.location.href='${pageContext.request.contextPath}/courses'">Back to Courses</button>
        
        <!-- Register Button -->
        <a href="${pageContext.request.contextPath}/courses/${course.getCourseid()}/register" class="register-button">Register</a>
    </div>
</body>
</html>
