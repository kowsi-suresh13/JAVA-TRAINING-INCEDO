<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Videos List</title>
    <style>
        /* Keeping the container style unchanged */
        .container {
            width: 80%;
            margin: auto;
            text-align: center;
            font-family: Arial, sans-serif;
        }

        /* Dark blue upper section */
        .header {
            background-color: #003366; /* Dark Blue */
            color: white;
            padding: 20px;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
        }

        /* Video Item Container */
        .video-item {
            margin: 20px 0;
            padding: 20px;
            border: 1px solid #ccc;  /* Border for each video */
            border-radius: 10px;
            background-color: #f9f9f9;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, border-color 0.3s ease;
        }

        /* Hover effect for video items */
        .video-item:hover {
            background-color: #f0f0f0;
            border-color: #003366;
        }

        /* Video Title */
        .video-title {
            font-size: 18px;
            font-weight: bold;
        }

        /* Button with icon */
        .button-with-icon {
            overflow: hidden;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            border: 1px solid #0f988e;
            font-family: "Istok Web", sans-serif;
            letter-spacing: 1px;
            padding: 0 12px;
            text-align: center;
            width: 120px;
            height: 40px;
            font-size: 14px;
            text-transform: uppercase;
            font-weight: normal;
            border-radius: 3px;
            outline: none;
            user-select: none;
            cursor: pointer;
            transform: translateY(0px);
            position: relative;
            box-shadow: inset 0 30px 30px -15px rgba(255, 255, 255, 0.1),
                        inset 0 0 0 1px rgba(255, 255, 255, 0.3),
                        inset 0 1px 20px rgba(0, 0, 0, 0),
                        0 3px 0 #0f988e,
                        0 3px 2px rgba(0, 0, 0, 0.2),
                        0 5px 10px rgba(0, 0, 0, 0.1),
                        0 10px 20px rgba(0, 0, 0, 0.1);
            background: #6c7b95;
            color: white;
            text-shadow: 0 1px 0 rgba(0, 0, 0, 0.3);
            transition: 150ms all ease-in-out;
            text-decoration: none;
        }

        .button-with-icon:hover {
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
    <!-- Dark Blue Upper Section (Header) -->
    <div class="header">
        <h2>Video Modules</h2>
    </div>

    <!-- Main Container for Videos -->
    <div class="container">
        <!-- Dynamically displaying each video item -->
        <c:forEach var="video" items="${videoList}">
            <div class="video-item">
                <span class="video-title">${video.videoTitle}</span>
                <a href="${pageContext.request.contextPath}/video/play?videoName=${video.videoName}" 
                   class="button-with-icon">
                    Play
                </a>
            </div>
        </c:forEach>

        <!-- Back to Courses Button -->
        <br>
        <a href="${pageContext.request.contextPath}/home/courses" class="button-with-icon">Back to Courses</a>
    </div>
</body>
</html>
