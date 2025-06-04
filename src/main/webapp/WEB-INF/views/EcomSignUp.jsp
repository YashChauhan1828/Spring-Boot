<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <div class="container-fluid">
 	<div class="row">
		<div class="col-md-3">
		
		</div>
	<div class="col-md-6">
		<h1>Ecom SignUp</h1>
 	<form action="esignup" method="post" enctype="multipart/form-data" >
 
	<div class="form-group">
		<label>FirstName: </label><input type="text" class="form-control" name="firstName" placeholder="Enter your name" value="${firstNameValue}"/><span style="color: red">${firstNameError}</span><br>
	</div>
	<div class="form-group">
		<label>Email: </label><input type="email" class="form-control" name="email" placeholder="Enter your Email" value="${emailValue}"/><span style="color: red" >${emailError}</span><br>
	</div>
	<div class="form-group">
		<label>Password: </label><input type="password" class="form-control" name="password" placeholder="Enter your password" value="${passwordValue}"/><span style="color: red">${passwordError}</span><br>
	</div>
	<div class="form-group">
		<label>ProfilePicture: </label><input class="form-control" type="file" name="profilePicture"/><br>
	<br>
	</div>
		<input type="submit" value="Signup" class="btn btn-success"/>  
 	</form>
 	 <p class="sign-up text-center">Already have an Account?<a href="/elogin">Login</a></p>
 	</div>
 </div> 
 </div>
</body>
</html>