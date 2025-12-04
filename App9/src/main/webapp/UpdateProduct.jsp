<%@page import="com.rohit.AdminBean"%>
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
			   AdminBean abean=(AdminBean) session.getAttribute("AdminBean");
				String data=(String)request.getAttribute("msg");
			    out.println("Hello "+abean.getU_fname()+"<br><br>");
			     out.println(data+"<br><br>");
			%>
			
			<a href="AddProduct.html">Add Product</a><br>
		<a href="view1">View Product</a><br>
		<a href="Logout">Logout</a>
		</h1>
</body>
</html>