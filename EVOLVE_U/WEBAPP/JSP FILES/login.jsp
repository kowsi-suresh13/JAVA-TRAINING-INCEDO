<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: skyblue;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
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

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #4CAF50;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
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
    </style>
</head>

<body>
	<c:if test="${not empty registrationSuccess}">
	        <div class="alert">
	            <span>${registrationSuccess}</span>
	        </div>
	</c:if>
    <div class="login-container">
        <h2>Login</h2>

        <!-- Change form action to the correct mapping -->
        <form action="/submitForm" method="POST">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>
        <!-- Show error message if login fails -->
        <div class="error-message">
            <h3>${error}</h3> <!-- This will display the error message -->
        </div>

        <div class="register-link">
            <p>Don't have an account? <a href="/roleSelection">Register here</a></p> <!-- Link to Registration Page -->
        </div>
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
