<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Checkout</h1>
Final Amount:${price.qty*price.price}
<br>
Credit Card Number:<input type="text" value="creditcardnumber" placeholder="Enter your Credit Card Number"/><br>
Expire Date:<input type="date" value="expdate"/><br>
CVV Number:<input type="text" value="cvv" placeholder="Enter your CVV Number"/><br>
<input type="submit" value="Pay"/>


</body>
</html>