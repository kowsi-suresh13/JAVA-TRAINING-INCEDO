<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Syllabus</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        form {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 20px;
            background-color: white;
            margin: 0 10%;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            margin-top: 10px;
        }

        textarea, input, select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #4682B4; /* Mid Blue */
            color: white;
            font-size: 1rem;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #315D8D;
        }

        .form-actions {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .back-btn {
            padding: 10px 20px;
            background-color: black;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }

        .back-btn:hover {
            background-color: #333;
        }

        .button-container {
            position: fixed;
            bottom: 20px;
            left: 20px;
            right: 20px;
            display: flex;
            justify-content: space-between;
        }

    </style>
</head>
<body>

    <h2>Update Syllabus</h2>

    <c:if test="${not empty message}">
        <p style="color: green; text-align: center;">${message}</p>
    </c:if>

    <!-- Form for updating syllabus -->
    <form action="${pageContext.request.contextPath}/syllabus/update" method="post">
        <input type="hidden" name="syllabusId" value="${syllabus.syllabusId}">

        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${syllabus.syllabusContent}</textarea>

        <label for="duration">Duration (in Hours):</label>
        <input type="number" id="duration" name="duration" value="${syllabus.duration}" required>

        <label for="videoStatus">Video Completed:</label>
        <select id="videoStatus" name="videoStatus">
            <option value="true" ${syllabus.videoStatus ? 'selected' : ''}>Yes</option>
            <option value="false" ${!syllabus.videoStatus ? 'selected' : ''}>No</option>
        </select>

        <label for="status">Syllabus Status:</label>
        <select id="status" name="status">
            <option value="true" ${syllabus.status ? 'selected' : ''}>Active</option>
            <option value="false" ${!syllabus.status ? 'selected' : ''}>Inactive</option>
        </select>

        <div class="button-container">
            <a href="${pageContext.request.contextPath}/syllabus/list?courseId=${syllabus.course.courseid}" class="back-btn">Back</a>
            <button type="submit">Update Syllabus</button>
        </div>
    </form>

</body>
</html>
