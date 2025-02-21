<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to EvolveU</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/front.css">
    <style>
        /* Full screen background animation with an interesting effect (gradient and parallax) */
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            background: url('https://www.w3schools.com/w3images/mountains.jpg') no-repeat center center fixed;
            background-size: cover;
            position: relative;
        }

        /* Parallax Effect */
        .parallax {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.5); /* Dark overlay to make text stand out */
            z-index: 1;
            animation: fadeInBackground 10s ease-in-out infinite;
        }

        @keyframes fadeInBackground {
            0% { opacity: 0.7; }
            50% { opacity: 1; }
            100% { opacity: 0.7; }
        }

        /* Header Styling */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #3498db; /* Blue background */
            color: white;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 10;
        }

        .logo h1 {
            margin: 0;
            font-size: 2.5rem;
        }

        /* Highlight the "U" in "EvolveU" */
        .logo h1 span {
            color: #f39c12; /* Orange color */
        }

        .navigation {
            display: flex;
            align-items: center;
        }

        .nav-item {
            color: white;
            margin: 0 10px;
            text-decoration: none;
            font-size: 1.2rem;
            font-weight: bold;
        }

        .nav-item:hover {
            text-decoration: underline;
        }

        /* Content Styling */
        .content {
            margin-top: 100px; /* To avoid content being hidden behind the fixed header */
            text-align: center;
            color: #ecf0f1;
            z-index: 5; /* Ensures text is on top of the background */
            position: relative;
        }

        .content h2 {
            font-size: 3rem;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 1.5rem;
            max-width: 800px;
            margin: 0 auto;
        }

        /* Remove Search Bar */
        .search-bar {
            display: none;
        }

        /* Responsive Design for Smaller Screens */
        @media (max-width: 768px) {
            .logo h1 {
                font-size: 2rem;
            }

            .content h2 {
                font-size: 2.5rem;
            }

            .content p {
                font-size: 1.2rem;
            }
        }

    </style>
</head>

<body>
    <!-- Parallax Effect (Overlayed on top of background) -->
    <div class="parallax"></div>

    <div class="header">
        <div class="logo">
            <h1>Evolv<span>eU</span></h1> <!-- "U" in orange -->
        </div>
        <div class="navigation">
            <a href="#" class="nav-item">Explore</a>
            <a href="/login/admin" class="nav-item">Login</a>
        </div>
    </div>

    <div class="content">
        <h2>Welcome to EvolveU!</h2>
        <p>Explore the best learning and development resources for you. Unlock your potential with a variety of courses and certificates.</p>
    </div>
</body>

</html>
