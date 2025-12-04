<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			<%
			String fname=(String)request.getAttribute("fname");
			out.println("Welcome "+fname+" <br><br>");
			%>
			<a href="view1">View Product</a><br> <a href="Logout">Logout</a>
		</h1>
</body>
</html>