<%@page import="com.rohit.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
				AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
			  ProductBean pb=(ProductBean) request.getAttribute("pbitem");
			  out.println("Hello "+abean.getU_fname()+" please Edit<br><br>");
			%>
			
			<form action="update" method="post">
			Product Price <input type="text" name="pprice" value="<%=pb.getP_price() %>"><br><br>
			Product Quantity <input type="text" name="pqty" value="<%=pb.getP_qty() %>"><br><br>
			<input type="hidden" name="pcode" value="<%= pb.getP_code() %>">
			<input type="submit" value="Update">
			</form>
		</h1>
</body>
</html>