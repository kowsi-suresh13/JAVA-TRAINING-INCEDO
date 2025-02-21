<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Syllabus</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        label {
            font-size: 16px;
            display: block;
            margin-bottom: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
        }
        .button-13 {
            background-color: #fff;
            border: 1px solid #d5d9d9;
            border-radius: 8px;
            box-shadow: rgba(213, 217, 217, 0.5) 0 2px 5px 0;
            box-sizing: border-box;
            color: #0f1111;
            cursor: pointer;
            font-size: 14px;
            padding: 8px 12px;
            width: 100%;
            transition: background-color 0.2s ease-in-out;
        }
        .button-13:hover {
            background-color: #f7fafa;
        }
        .button-13:focus {
            border-color: #008296;
            box-shadow: rgba(213, 217, 217, 0.5) 0 2px 5px 0;
            outline: none;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Enter Course ID to Add Syllabus</h2>

        <form action="${pageContext.request.contextPath}/syllabus/ask" method="post">
            <label for="courseId">Course ID:</label>
            <input type="number" id="courseId" name="courseId" required>

            <button type="submit" class="button-13">Proceed</button>
        </form>
    </div>

</body>
</html>
