<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - Bharat Secure Bank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
            background-size: 400% 400%;
            animation: gradientMove 12s ease infinite, fadeIn 1s ease-in-out;
            height: 100vh;
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Poppins", sans-serif;
        }
        @keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
        @keyframes slideUp { from { transform: translateY(40px); opacity:0; } to { transform: translateY(0); opacity:1; } }
        .login-box {
            background: rgba(255, 255, 255, 0.15);
            padding: 40px;
            width: 390px;
            backdrop-filter: blur(10px);
            border-radius: 20px;
            text-align: center;
            border: 1px solid rgba(255,255,255,0.3);
            box-shadow: 0 8px 25px rgba(0,0,0,0.35);
            animation: slideUp .7s ease;
            position: relative;
            z-index: 2;
        }
        .bank-logo { width: 90px; margin-bottom: 15px; }
        .login-title { font-size: 30px; font-weight: 700; color: white; margin-bottom: 15px; }
        .input-group-text, .form-control { background: rgba(255,255,255,0.2); border: none; color: white; }
        .form-control::placeholder { color: #ddd; }
        .btn-login {
            width: 100%; padding: 10px; margin-top: 15px;
            border-radius: 30px; font-size: 18px; font-weight: 600;
        }
        .register-btn { width: 100%; margin-top: 15px; padding: 10px; border-radius: 30px; }

        /* Animated gradient */
        @keyframes gradientMove {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Floating dots */
        .particle {
            position: absolute;
            width: 6px;
            height: 6px;
            background: rgba(255,255,255,0.6);
            border-radius: 50%;
            animation: floatUp 7s linear infinite;
            z-index: 0;
        }

        @keyframes floatUp {
            from { transform: translateY(100vh); opacity: 0.2; }
            to { transform: translateY(-10vh); opacity: 1; }
        }

        /* Wave layer */
        .wave-layer {
            position: absolute;
            bottom: -80px;
            width: 200%;
            height: 200px;
            background: rgba(255,255,255,0.05);
            border-radius: 100%;
            animation: waveMove 6s linear infinite;
            z-index: 0;
        }
        @keyframes waveMove {
            from { transform: translateX(-50px); }
            to { transform: translateX(50px); }
        }

        /* Error message box */
        .error-box {
            background: rgba(255,0,0,0.15);
            border-left: 4px solid #ff4d4d;
            padding: 10px 15px;
            border-radius: 8px;
            color: #ffcccc;
            font-weight: 600;
            margin-bottom: 15px;
            animation: shake 0.3s ease;
        }
        @keyframes shake {
            0% { transform: translateX(0); }
            25% { transform: translateX(-5px); }
            50% { transform: translateX(5px); }
            75% { transform: translateX(-5px); }
            100% { transform: translateX(0); }
        }
    </style>
</head>
<body>

<!-- Floating dots -->
<div class="particle" style="left:15%; animation-duration:6s;"></div>
<div class="particle" style="left:30%; animation-duration:8s;"></div>
<div class="particle" style="left:45%; animation-duration:10s;"></div>
<div class="particle" style="left:60%; animation-duration:7s;"></div>
<div class="particle" style="left:75%; animation-duration:9s;"></div>

<!-- Wave -->
<div class="wave-layer"></div>

<div class="login-box">
    <img src="https://cdn-icons-png.flaticon.com/512/3135/3135706.png" class="bank-logo">
    <h2 class="login-title">User Login</h2>

    <% String msg = (String)request.getAttribute("msg"); 
       if(msg != null){ %>
        <div class="error-box"><%= msg %></div>
    <% } %>

    <form action="login" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
            <input type="text" name="uname" class="form-control" placeholder="Enter Username" required>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
            <input type="password" name="pass" class="form-control" placeholder="Enter Password" required>
        </div>

        <button type="submit" class="btn btn-light btn-login">Login</button>
    </form>

    <a href="Register.jsp" class="btn btn-outline-light register-btn">Create New Account</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.js"></script>
</body>
</html>
