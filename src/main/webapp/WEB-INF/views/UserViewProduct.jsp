<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>View Product</h2>
	ProductName: ${product.productName}<br>
	Price: ${product.price }<br>
	Category: ${product.category}<br>
	Image: <img src="${product.productImagePath }"/> 
</body>
</html>