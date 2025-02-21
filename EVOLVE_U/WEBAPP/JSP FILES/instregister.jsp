<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Registration</title>
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

        .register-container {
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
        input[type="password"],
        input[type="email"] {
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
    </style>
</head>

<body>
    <div class="register-container">
        <h2>Instructor Registration</h2>
        <form action="/submitinsRegistration" method="POST">
            <label for="instructorId">Instructor ID:</label>
            <input type="text" id="instructorId" name="instructorId" required><br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>

            <label for="emailId">Email ID:</label>
            <input type="email" id="emailId" name="emailId" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required><br>

            <label for="qualification">Qualification:</label>
            <input type="text" id="qualification" name="qualification" required><br>
			
			<label for="achievement">Achievement:</label>
			<input type="text" id="achievement" name="achievement" required><br>
						
		    <label for="workExperience">WorkExperience:</label>
	        <input type="text" id="workExperience" name="workExperience" required><br>

            <input type="submit" value="Register">
        </form>
    </div>
</body>

</html>
