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
Name:<input type="text" name="full_name" placeholder="Enter Your name"/><span style="color: red">${NameError}</span><br>
Address line 1:<input type="text" name="address_line1"/><span style="color: red">${AddressError}</span><br>
Address line 2:<input type="text" name="address_line2"/><span style="color: red">${AddressError}</span><br>
City :<select name="city">
		<option>Select City</option>
		<option>Surat</option>
		<option>Ahmedabad</option>
		<option>vadodara</option>
		<option>Rajkot</option>
		<option>Gandhinagar</option>
</select><span style="color: red">${CityError}</span><br>
State :<select name="state">
		<option>Select State</option>
		<option>Gujarat</option>
		<option>Maharastra</option>
		<option>Jammu and Kashmir</option>
</select><span style="color: red">${StateError}</span><br>
zip Code:<input type="text" name="zip_code"/><span style="color: red">${codeError}</span><br>
Country :<select name="country">
		<option>Select Country</option>
		<option>India</option>
		<option>UAE</option>
		<option>USA</option>
</select><span style="color: red">${CountryError}</span><br>
Phone Number: <input type="text" name="phone_number"/><span style="color: red">${PhoneError}</span><br>
<input type="submit" value="Order"/>
</form>
</body>
</html>

