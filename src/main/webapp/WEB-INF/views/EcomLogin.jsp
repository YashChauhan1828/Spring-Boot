<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Ecom Login</h1>
${error}
	<form action="elogin" method="post">
	Email: <input type="text" name="email" placeholder="Enter your name"/><br>
	Password: <input type="passowrd" name="password" placeholder="Enter your Email" /><br><br>
	<input type="submit" value="login"/>
	</form>
</body>
</html>