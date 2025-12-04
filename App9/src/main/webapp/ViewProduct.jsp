<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rohit.ProductBean"%>
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
				ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
				out.println("<u>Hello "+abean.getU_fname()+" these are your product details</u><br><br>");
				
				if(al.size()==0){
					out.println("Product inventry is Empty :");
				}
				else{
					Iterator<ProductBean> i=al.iterator();
					
					while(i.hasNext())
					{
						ProductBean pb=i.next();
						
						out.println(pb.getP_code()+" "+
						pb.getP_name()+" "+
						pb.getP_company()+" "+
						pb.getP_price()+" "+
						pb.getP_qty()+
						"<a href='edit?pcode="+pb.getP_code()+"'>Edit</a>"+
						" "+"<a href='delete?pcode="+pb.getP_code()+"'>Delete</a>"+
						"<br><br>");
					}
				}
			%>
		</h1>
</body>
</html>