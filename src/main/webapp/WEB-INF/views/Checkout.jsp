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
<br>
<form action="epayment" method="post">
Final Amount: <input type="hidden" name="price" value="${totalPrice}"/>
Credit Card Number:<input type="text" name="creditcardnumber" placeholder="Enter your Credit Card Number"/><br>
Expire Date:<input type="text" name="date"/><br>
CVV Number:<input type="text" name="cvv" placeholder="Enter your CVV Number"/><br>
<input type="submit" value="Pay"/>
</form>

</body>
</html>