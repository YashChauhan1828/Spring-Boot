<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>

FirstName : ${user.firstName}<br>
path: <img src="${user.profilePicturePath}" height="100px" width="100px" /><br>
<a href="products">Products</a>
</html>