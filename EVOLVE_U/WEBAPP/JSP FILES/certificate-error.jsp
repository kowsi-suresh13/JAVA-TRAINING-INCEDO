<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: #ffe6e6;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .error-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(255, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
            text-align: center;
            border-left: 5px solid #ff4444;
            transform: translateY(0);
            animation: float 3s ease-in-out infinite;
        }

        h2 {
            color: #ff4444;
            margin-bottom: 20px;
            font-size: 32px;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }

        .error-icon {
            font-size: 40px;
            animation: shake 0.5s ease-in-out;
        }

        p {
            color: #666;
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 30px;
        }

        .back-link {
            display: inline-block;
            background: #ff4444;
            color: white !important;
            padding: 12px 30px;
            border-radius: 25px;
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s ease;
            border: 2px solid transparent;
        }

        .back-link:hover {
            background: white;
            color: #ff4444 !important;
            border-color: #ff4444;
            transform: translateY(-2px);
        }

        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-5px); }
            75% { transform: translateX(5px); }
        }

        @keyframes float {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-10px); }
        }

        @media (max-width: 480px) {
            .error-container {
                padding: 25px;
            }
            
            h2 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h2>
            <span class="error-icon">⚠️</span>
            Oops! Something Went Wrong
        </h2>
        <p>${error}</p>
        <a href="/certificatesform" class="back-link">Return to Safety</a>
    </div>
</body>
</html>