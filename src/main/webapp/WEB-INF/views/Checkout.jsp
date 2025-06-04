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
Final Amount: ${totalPrice}<input type="hidden" name="price" value="${totalPrice}"/><br>
Credit Card Number:<input type="text" name="creditcardnumber" placeholder="Enter your Credit Card Number"/><span style="color: red">${CardError}</span><br>
Expire Date:<input type="text" name="date"/><span style="color: red">${DateError}</span><br>
CVV Number:<input type="text" name="cvv" placeholder="Enter your CVV Number"/><span style="color: red">${CVVError}</span><br>
<input type="submit" value="Pay"/>
</form>

</body>
</html>