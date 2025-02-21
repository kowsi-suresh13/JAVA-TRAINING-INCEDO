<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Course</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .form-container {
            text-align: center;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-size: 16px;
            margin-right: 10px;
        }
        input {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }
        button {
            padding: 8px 15px;
            border: 1px solid #28a745;
            color: #28a745;
            border-radius: 5px;
            cursor: pointer;
            background-color: transparent;
            margin-top: 10px;
        }
        button:hover {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Select Course to Update Syllabus</h2>

        <form action="${pageContext.request.contextPath}/syllabus/update/list" method="get">
            <label for="courseId">Enter Course ID:</label>
            <input type="number" id="courseId" name="courseId" required>
            <button type="submit">Proceed</button>
        </form>
    </div>

</body>
</html>
