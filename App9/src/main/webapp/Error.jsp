<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #ACB6E5);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
	<center>
		<h1>
			<%
				String msg=(String)request.getAttribute("msg");
			//out.println(msg);
			response.sendError(405,msg);
			%>
			<%= msg %><br><br>
			<a href="AddProduct.html">Add Product</a><br>
		<a href="view1">View Product</a><br>
		<a href="Logout">Logout</a>
		</h1>
</body>
</html>