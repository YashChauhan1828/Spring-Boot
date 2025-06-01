<%@page import="com.bean.EcomProductCartBean"%>
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
	
	<% List<EcomProductCartBean> products = (List<EcomProductCartBean>) request.getAttribute("products"); 
	Float Total_Price = 0.0f;
	%>
<table border="1">
	<tr>
		<th>CartId</th>
		<th>ProductId</th>
		<th>ProductName</th>
		<th>Image</th>
		<th>Price</th>
		<th>Qty</th>
		<th>Total Price</th>
		<th>Decrease Quantity</th>
		<th>Increase Quantity</th>
		<th>Action</th>
	</tr>
	<% 
		for(EcomProductCartBean p : products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getCartId()+"</td>");
			out.print("<td>"+p.getProductId()+"</td><td>"+p.getProductName() + "</td>");
			out.print("<td><img src='"+p.getProductImagePath()+"'/></td>");
			out.print("<td>"+p.getPrice()+"</td>");
			out.print("<td>"+p.getQty()+"</td>");
			out.print("<td>"+p.getQty()*p.getPrice()+"</td>");
			out.print("<td><a href='minusqty?cartId="+p.getCartId()+"'>-</td>");
			out.print("<td><a href='plusqty?cartId="+p.getCartId()+"'>+</td>");
			out.print("<td><a href ='removecartitem?cartId="+p.getCartId()+"'>Remove</a></td>");
			out.print("</tr>");
		
			Total_Price += (p.getPrice()*p.getQty());
		}
	
	%>
</table>
<br> Sub Total <%=Total_Price %>
<% session.setAttribute("totalPrice", Total_Price); %>
<br><br>
<a href="inputmail">Checkout</a>
<a href="userproducts">Back To Products</a>
</body>
</html>