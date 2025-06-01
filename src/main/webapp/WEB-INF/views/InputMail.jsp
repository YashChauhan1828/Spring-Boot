<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Mail</title>
</head>
<body>
<h1>Email Verfication</h1>
<form action="sendmail" method="post">
	Email: <input type="email" name="email" placeholder="Enter yourn mail"/><br><br>
	<input type="submit" value="Send Mail"/> 
</form>
</body>
</html>