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
			<h1> Ecom Login</h1>

			${error}
			<form action="elogin" method="post">
			<div class="form-group">
			<label>Email: </label><input type="text" class="form-control" name="email" placeholder="Enter your Email Address"/><br>
			</div>
			<div class="form-group">
			<label>Password: </label><input type="password" class="form-control" name="password" placeholder="Enter your Password" /><br><br>
			</div>
			<input type="submit" value="login" class="btn btn-success"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>