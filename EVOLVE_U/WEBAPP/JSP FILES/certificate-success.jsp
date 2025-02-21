<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Certificate Generated</title>
<style>
        body {
            font-family: 'Times New Roman', serif;
            background: #faf8f0;
            margin: 0;
            padding: 40px 0;
            min-height: 100vh;
        }
        
        .certificate-container {
            background: url('https://www.transparenttextures.com/patterns/cream-paper.png');
            width: 800px;
            margin: 0 auto;
            padding: 60px 100px;
            border: 15px solid #2c1810;
            position: relative;
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
        }
        
        .ornate-border {
            position: absolute;
            width: 90%;
            height: 85%;
            border: 2px solid #c5a880;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        
        h1 {
            color: #2c1810;
            font-size: 36px;
            text-transform: uppercase;
            letter-spacing: 4px;
            text-align: center;
            margin-bottom: 40px;
            font-family: 'Playfair Display', serif;
        }
        
        .certificate-content {
            text-align: center;
            margin: 40px 0;
        }
        
        .certificate-of {
            font-size: 24px;
            color: #666;
            margin-bottom: 10px;
        }
        
        .user-name {
            font-size: 42px;
            color: #2c1810;
            margin: 25px 0;
            font-weight: bold;
            border-bottom: 2px solid #c5a880;
            display: inline-block;
            padding-bottom: 10px;
        }
        
        .certificate-text {
            font-size: 20px;
            line-height: 1.6;
            color: #444;
            margin: 25px 0;
        }
        
        .details {
            margin: 30px 0;
            font-size: 18px;
            color: #666;
        }
        
        .seal {
            position: absolute;
            width: 120px;
            height: 120px;
            background: #c5a880;
            border-radius: 50%;
            right: 30px;
            bottom: 30px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-style: italic;
            border: 3px solid #2c1810;
        }
        
        .button {
            background: #2c1810;
            color: #fff;
            padding: 12px 30px;
            text-decoration: none;
            border-radius: 30px;
            display: inline-block;
            margin-top: 30px;
            font-size: 16px;
            transition: all 0.3s ease;
            border: 2px solid #2c1810;
        }
        
        .button:hover {
            background: #fff;
            color: #2c1810;
        }
        
        .footer {
            margin-top: 40px;
            font-size: 22px;
            color: #2c1810;
            font-family: 'Playfair Display', serif;
        }
        
        .gold-text {
            color: #c5a880;
        }
        
        .decoration {
            position: absolute;
            width: 80px;
            opacity: 0.2;
        }
        
        .decoration.left {
            left: 20px;
            top: 20px;
        }
        
        .decoration.right {
            right: 20px;
            top: 20px;
            transform: scaleX(-1);
        }
</style>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet">
</head>
<body>
<div class="certificate-container">
    <div class="ornate-border"></div>
    <img src="https://cdn-icons-png.flaticon.com/512/1539/1539773.png" class="decoration left">
    <img src="https://cdn-icons-png.flaticon.com/512/1539/1539773.png" class="decoration right">
    
    <h1>Certificate of Achievement</h1>
    
    <div class="certificate-content">
        <div class="certificate-of">This Certificate is Proudly Presented To</div>
        <div class="user-name">${user.name}</div>
        
        <div class="certificate-text">
            has successfully completed the course of study in<br>
            <span class="gold-text" style="font-size: 24px;">${course.name}</span>
        </div>
        
        <div class="details">
            <p>Certificate ID: ${certificateId}</p>
        </div>
    </div>
    
    <div class="seal">
        <div style="text-align: center;">
            <span style="font-size: 12px;">Seal of</span><br>
            <strong>EvolveU</strong>
        </div>
    </div>
    
    <div class="footer">
        <div style="border-top: 2px solid #c5a880; width: 200px; margin: 0 auto 15px;"></div>
        www.evolveu.com
    </div>
</div>

<center style="margin: 30px;">
    <a href="http://localhost:8090/generateCertificate" class="button">Generate Another Certificate</a>
</center>

</body>
</html>