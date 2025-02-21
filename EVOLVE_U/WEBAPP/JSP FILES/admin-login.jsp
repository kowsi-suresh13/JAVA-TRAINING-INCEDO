<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: white; /* White background for the entire page */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            flex-direction: column; /* Allow content to be arranged in columns */
        }

        .login-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-size: 16px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            text-align: center;
            font-size: 14px;
            margin-top: 10px;
        }

        .popup {
            position: fixed;
            top: 10px;
            left: 50%;
            transform: translateX(-50%);
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            border-radius: 5px;
            font-size: 16px;
            z-index: 9999;
            display: none;
        }

        /* Box style for Learner and Instructor login options at the bottom */
        .login-options-box {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 8px;
            width: 300px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
            text-align: center;
        }

        .login-options-box p {
            margin-bottom: 10px;
            font-size: 18px;
            font-weight: bold;
        }

        .login-options-box a {
            display: block;
            color: #4CAF50;
            text-decoration: none;
            margin: 10px 0;
            font-size: 16px;
        }

        .login-options-box a:hover {
            text-decoration: underline;
        }

    </style>
</head>

<body>
    <c:if test="${not empty registrationSuccess}">
        <div class="alert">
            <span>${registrationSuccess}</span>
        </div>
    </c:if>

    <div class="login-container">
        <h2>Admin Login</h2>

        <!-- Change form action to the correct mapping -->
        <form action="/submitAdmin" method="POST">
            <label for="adminId">User ID:</label>
            <input type="text" id="adminId" name="adminId" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>

        <!-- Show error message if login fails -->
        <div class="error-message">
            <h3>${error}</h3> <!-- This will display the error message -->
        </div>
    </div>

    <!-- Learner and Instructor Login options in a box at the bottom -->
    <div class="login-options-box">
        <p>Not an Admin? Select your role:</p>
        <a href="/login/learner">Learner Login</a>
        <a href="/login/instructor">Instructor Login</a>
    </div>

    <!-- JavaScript for Popup -->
    <script type="text/javascript">
        // JSP condition to check if registrationSuccess exists
        var registrationSuccessMessage = "${registrationSuccess}"; // Getting the message from JSP

        // If registrationSuccessMessage is not empty, show the popup
        if (registrationSuccessMessage) {
            var popup = document.getElementById("popupMessage");
            popup.style.display = "block";

            // Hide the popup after 5 seconds
            setTimeout(function() {
                popup.style.display = "none";
            }, 5000);  // 5000ms = 5 seconds
        }
    </script>
</body>

</html>
