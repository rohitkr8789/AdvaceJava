<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
        min-height: 100vh;
        margin: 0;
        font-family: "Poppins", sans-serif;
        color: #ffffff;
        overflow-x: hidden;
        animation: fadeIn 1.2s ease-in-out;
    }
    @keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

    .particle {
        position: absolute;
        background: rgba(255,255,255,0.35);
        width: 6px; height: 6px;
        border-radius: 50%;
        animation: floatUp 7s linear infinite;
    }
    @keyframes floatUp { from { transform:translateY(100vh);} to { transform:translateY(-10vh);} }

    .navbar {
        background: rgba(0,0,0,0.35) !important;
        backdrop-filter: blur(10px);
        border-bottom: 1px solid rgba(255,255,255,0.2);
    }
    .navbar-brand { font-size: 26px; font-weight:700; color:#fff !important; }
    .nav-link { color:#ddd !important; margin-right:15px; font-weight:500; }
    .nav-link:hover { color:#fff !important; transform:scale(1.05); }

    .register-card {
        background: rgba(255,255,255,0.12);
        padding: 20px;
        border-radius: 16px;
        backdrop-filter: blur(12px);
        border: 1px solid rgba(255,255,255,0.25);
        box-shadow: 0 8px 25px rgba(0,0,0,0.35);
        width: 420px;
        text-align: center;
        animation: fadeIn 1.6s ease-in-out;
    }

    input, select {
        width: 100%;
        padding: 10px;
        border-radius: 8px;
        border: none;
        margin-top: 10px;
        outline: none;
    }

    .btn-register {
        background: #00eaff;
        color: #000;
        border-radius: 30px;
        padding: 12px 30px;
        font-size: 18px;
        font-weight: 600;
        margin-top: 20px;
        transition: 0.3s;
        width: 100%;
    }
    .btn-register:hover { transform:scale(1.05); box-shadow:0 10px 25px rgba(0,234,255,0.45); }
</style>
</head>
<body>

<!-- particles -->
<div class="particle" style="left:10%; animation-duration:7s;"></div>
<div class="particle" style="left:25%; animation-duration:9s;"></div>
<div class="particle" style="left:40%; animation-duration:6s;"></div>
<div class="particle" style="left:55%; animation-duration:8s;"></div>
<div class="particle" style="left:70%; animation-duration:10s;"></div>
<div class="particle" style="left:85%; animation-duration:7s;"></div>

<nav class="navbar navbar-expand-lg navbar-dark px-4">
  <a class="navbar-brand" href="Dashboard.jsp">Bharat Secure Bank</a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ms-auto">
      <li class="nav-item"><a class="nav-link" href="Dashboard.jsp">Home</a></li>
      
      
      <li class="nav-item"><a class="nav-link" href="Login.jsp">Logout</a></li>
      
    </ul>
  </div>
</nav>

<%
    String msg = (String)request.getAttribute("msg");
%>

<div class="container d-flex justify-content-center mt-4">
    <div class="register-card">

        <img src="https://cdn-icons-png.flaticon.com/512/3135/3135706.png" style="width:70px; height:70px; border-radius:12px; border:2px solid #00eaff; box-shadow:0 0 12px rgba(0,234,255,0.6); margin-bottom:0px;">

        <h2 style="font-weight:600;">Create Account</h2>

        <% if(msg != null){ %>
            <p style="color:#00eaff; font-weight:600;"> <%= msg %> </p>
        <% } %>

        <form action="register" method="post">
            <input type="text" name="flname" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email Address" required>
            <input type="text" name="phone" placeholder="Phone Number" required>
            <input type="text" name="uname" placeholder="Username" required>
            <input type="password" name="pass" placeholder="Password" required>
            <input type="password" name="cpass" placeholder="Confirm Password" required>
            <input type="text" name="addr" placeholder="Address" required>

            <select name="acctype" required>
                <option value="Saving">Saving Account</option>
                <option value="Current">Current Account</option>
            </select>

            <input type="submit" value="Register" class="btn-register">
        </form>

        <a href="Login.jsp" style="color:#ffcb2f; font-weight:600; display:block; margin-top:10px;">Already have an account? Login</a>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
