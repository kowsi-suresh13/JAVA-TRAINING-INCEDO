<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter Course ID</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        /* Amazon-style Button 13 */
        .button-13 {
            background-color: #fff;
            border: 1px solid #d5d9d9;
            border-radius: 8px;
            box-shadow: rgba(213, 217, 217, .5) 0 2px 5px 0;
            color: #0f1111;
            cursor: pointer;
            font-size: 13px;
            line-height: 29px;
            padding: 0 10px;
            text-align: center;
            width: 100px;
        }
        .button-13:hover {
            background-color: #f7fafa;
        }
        .button-13:focus {
            border-color: #008296;
            box-shadow: rgba(213, 217, 217, .5) 0 2px 5px 0;
            outline: 0;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h3>Enter Course ID</h3>
        <form action="#" method="get" onsubmit="redirectToUpdatePage(event)">
            <label for="courseId">Course ID:</label>
            <input type="number" id="courseId" name="id" min="1" required>
            <br>
            <button type="submit" class="button-13">Proceed</button>
        </form>
    </div>

    <script>
        var contextPath = "${pageContext.request.contextPath}"; // Store JSP variable in JS

        function redirectToUpdatePage(event) {
            event.preventDefault();
            var courseId = document.getElementById("courseId").value;
            if (courseId) {
                window.location.href = contextPath + "/courses/update/" + courseId;
            }
        }
    </script>

</body>
</html>
