<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="esignup" method="post" enctype="multipart/form-data">
	<h1>Ecom SignUp</h1>
	FirstName: <input type="text" name="firstName" placeholder="Enter your name" value="${firstNameValue}"/><span style="color: red">${firstNameError}</span><br>
	Email: <input type="email" name="email" placeholder="Enter your Email" value="${emailValue}"/><span style="color: red" >${emailError}</span><br>
	Password: <input type="password" name="password" placeholder="Enter your password" value="${passwordValue}"/><span style="color: red">${passwordError}</span><br>
	ProfilePicture: <input type="file" name="profilePicture"/><br>
	<br>
	<input type="submit" value="Signup"/>  
 </form> 
</body>
</html>