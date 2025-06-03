<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Shipping Details</h1>
<form action="eshipping" method="post">
Name:<input type="text" name="full_name" placeholder="Enter Your name"/><br>
Address line 1:<input type="text" name="address_line1"/><br>
Address line 2:<input type="text" name="address_line2"/><br>
City :<select name="city">
		<option>Select City</option>
		<option>Surat</option>
		<option>Ahmedabad</option>
		<option>vadodara</option>
		<option>Rajkot</option>
		<option>Gandhinagar</option>
</select><br>
State :<select name="state">
		<option>Select State</option>
		<option>Gujarat</option>
		<option>Maharastra</option>
		<option>Jammu and Kashmir</option>
</select><br>
zip Code:<input type="text" name="zip_code"/><br>
Country :<select name="country">
		<option>Select Country</option>
		<option>India</option>
		<option>UAE</option>
		<option>USA</option>
</select><br>
Phone Number: <input type="text" name="phone_number"/><br>
<input type="submit" value="Order"/>
</form>
</body>
</html>