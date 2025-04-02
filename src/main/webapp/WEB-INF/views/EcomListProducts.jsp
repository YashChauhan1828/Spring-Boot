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
	<h1>List products</h1>
	<% List<EcomProductBean> products = (List<EcomProductBean>) request.getAttribute("products"); %>
<table border="1">
	<tr>
		<th>ProductId</th>
		<th>ProductName</th>
	</tr>
	<% 
		for(EcomProductBean p : products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getProductId()+"</td><td>"+p.getProductName() + "</td>");
			out.print("</tr>");
		}
	
	%>
</table>
</body>
</html>