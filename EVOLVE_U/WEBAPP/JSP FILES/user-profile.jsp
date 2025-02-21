<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9; /* Light gray background */
            color: #333; /* Dark text for readability */
            margin: 0;
            padding: 0;
        }

        /* Header Styles */
        h1 {
            background-color: #003366; /* Dark Blue */
            color: white;
            padding: 20px;
            text-align: center;
            margin: 0;
            font-size: 36px;
        }

        /* Profile Container */
        .profile-container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: white; /* White background for the profile section */
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); /* Soft shadow for the profile */
            border-radius: 8px;
            font-size: 18px;
        }

        /* Profile Information Style */
        .profile-container p {
            margin: 10px 0;
            padding: 8px;
            font-size: 18px;
            color: #333;
        }

        .profile-container p strong {
            color: #003366; /* Dark Blue for labels */
            font-weight: bold;
        }

        .profile-container span {
            color: #6c7b95; /* Soft grayish text for the data */
        }

        /* Dynamic Background Color on Hover (for an interactive effect) */
        .profile-container p:hover {
            background-color: #ffe0b3; /* Light Orange on hover */
            cursor: pointer;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .profile-container {
                width: 90%;
            }

            h1 {
                font-size: 28px;
            }
        }

    </style>
</head>
<body>
    <h1>User Profile</h1>
    
    <div class="profile-container">
        <p><strong>Name:</strong> <span>${user.name}</span></p>
        <p><strong>User ID:</strong> <span>${user.userId}</span></p>
        <p><strong>Email ID:</strong> <span>${user.emailId}</span></p>
        <p><strong>Phone Number:</strong> <span>${user.phoneNumber}</span></p>
        <p><strong>School:</strong> <span>${user.school}</span></p>
    </div>
    
</body>
</html>
