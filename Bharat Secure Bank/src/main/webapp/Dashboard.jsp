<%@page import="bank.bharat.helper.CurrentBalance"%>
<%@page import="bank.bharat.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
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

    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }

    .particle {
        position: absolute;
        background: rgba(255,255,255,0.35);
        width: 6px;
        height: 6px;
        border-radius: 50%;
        animation: floatUp 7s linear infinite;
    }

    @keyframes floatUp {
        from { transform: translateY(100vh); }
        to { transform: translateY(-10vh); }
    }

    .navbar {
        background: rgba(0,0,0,0.35) !important;
        backdrop-filter: blur(10px);
        border-bottom: 1px solid rgba(255,255,255,0.2);
    }

    .navbar-brand {
        font-size: 26px;
        font-weight: 700;
        color: #fff !important;
        letter-spacing: 1px;
    }

    .nav-link {
        color: #ddd !important;
        margin-right: 15px;
        font-weight: 500;
        transition: 0.3s;
    }

    .nav-link:hover {
        color: #fff !important;
        transform: scale(1.05);
    }

    .btn-transfer {
        background: #00eaff;
        color: #000;
        border-radius: 30px;
        padding: 12px 30px;
        font-size: 18px;
        font-weight: 600;
        margin-top: 20px;
        transition: 0.3s;
    }

    .btn-transfer:hover {
        transform: scale(1.12);
        box-shadow: 0 10px 25px rgba(0,234,255,0.45);
        color: #000;
    }
</style>
</head>
<body>

<!-- Floating particles -->
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
      <li class="nav-item"><a class="nav-link" href="loan.jsp">Loan</a></li>
      <li class="nav-item"><a class="nav-link" href="History.jsp">History</a></li>
      <li class="nav-item"><a class="nav-link" href="Edit.jsp">Edit</a></li>
      <li class="nav-item"><a class="nav-link" href="Login.jsp">Logout</a></li>
       </ul>   

  </div>
</nav>

<%
    String name = (String) session.getAttribute("fname");
    RegisterBean rb = (RegisterBean) session.getAttribute("rb");
    Double amt = null;
    if (rb != null) {
        amt = CurrentBalance.currentBal(rb.getAccno());
    }
%>

<div class="container">
    <div class="d-flex justify-content-center mt-5" style="animation: fadeIn 1.6s ease-in-out;">
    <div style="background: rgba(255,255,255,0.12); padding:35px; border-radius:16px; backdrop-filter: blur(12px); border:1px solid rgba(255,255,255,0.25); box-shadow:0 8px 25px rgba(0,0,0,0.35); width:480px; height:auto; text-align:center;">
        <img src="https://cdn-icons-png.flaticon.com/512/3135/3135706.png" style="width:110px; height:110px; border-radius:12px; border:2px solid #00eaff; box-shadow:0 0 12px rgba(0,234,255,0.6); margin-bottom:15px;">

        <h2 style="font-weight:600; text-shadow:0 2px 4px rgba(0,0,0,0.4);">
            <%= (name == null) ? "Welcome Back" : ("Welcome " + name) %>
        </h2>

        <% if (amt != null) { %>
        <p style="font-size:26px; font-weight:600; color:#00eaff; text-shadow:0 0 8px rgba(0,234,255,0.6); margin-top:10px;">
            Balance: ₹ <%= amt %>
        </p>
        <% } %>

        <a href="Transfer.jsp" class="btn btn-transfer mt-3">Transfer Money</a>
    </div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
