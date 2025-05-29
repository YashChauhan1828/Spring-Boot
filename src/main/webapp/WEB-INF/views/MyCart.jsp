<%@page import="java.util.List"%>
<%@page import="com.bean.EcomProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Cart</h1>
	
	<% List<EcomProductBean> products = (List<EcomProductBean>) request.getAttribute("products"); 
	Float Total_Price = 0.0f;
	%>
<table border="1">
	<tr>
		<th>ProductId</th>
		<th>ProductName</th>
		<th>Image</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	<% 
		for(EcomProductBean p : products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getProductId()+"</td><td>"+p.getProductName() + "</td>");
			out.print("<td><img src='"+p.getProductImagePath()+"'/></td>");
			out.print("<td>"+p.getPrice()+"</td>");
			out.print("<td><a href ='removecartitem?productId="+p.getProductId()+"'>Remove</a></td>");
			out.print("</tr>");
		
			Total_Price += p.getPrice();
		}
	
	%>
</table>
<br> Sub Total <%=Total_Price %>
<br><br>
<a href="checkout">Checkout</a>
</body>
</html>