<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Play Video</title>
    <style>
        .container {
            width: 80%;
            margin: auto;
            text-align: center;
            font-family: Arial, sans-serif;
            position: relative;
        }
        video {
            width: 70%;  /* Adjust the video size */
            height: auto;
            border: 1px solid #ccc;
        }
        .back-button {
            position: absolute;
            left: 20px;
            bottom: 20px;
            padding: 10px 20px;
            background-color: #0f988e;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-button:hover {
            background-color: #0a6e6b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>VIDEO PLAYING</h2>

        <!-- Use the videoName passed from the controller -->
        <c:if test="${not empty videoName}">
            <video controls>
                <!-- Stream the video from the '/syllabus/video/play/stream' URL -->
                <source src="${pageContext.request.contextPath}/video/play/stream?videoName=${videoName}" type="video/mp4">
                Your browser does not support the video tag.
            </video>
        </c:if>

        <br>
        <a href="${pageContext.request.contextPath}/home/courses" class="back-button">Back</a>
    </div>
</body>
</html>
