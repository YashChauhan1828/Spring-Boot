<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Registration Form</h1><br><br>
	<form action="savereg" method="post">
		Student Name: <input type="text" name="studentName" value="${reg.studentNameValue}"/><span style="color:red">${studentNameError}</span><br>
		Playing Type: Batsman <input type="radio" name="playerType" value="Batsman" ${playerTypeValue!=null && playerTypeValue.equals("Batsman")?"checked":""}/>
					  Bowler <input type="radio" name="playerType" value="Bowler" ${playerTypeValue!=null && playerTypeValue.equals("Bowler")?"checked":""}/>
					  All Rounder <input type="radio" name="playerType" value="AllRounder" ${playerTypeValue!=null && playerTypeValue.equals("AllRounder")?"checked":""}/>
					  <span style="color:red">${playerTypeError}</span><br>
		Food Preference:
		<select name="foodPreference">
			<option value="-1">Select your Food Preference</option>
			<option value="Jain" ${foodPreferenceValue!=null && foodPreferenceValue.equals("Jain")?"selected":""}>Jain</option>
			<option value="Regular" ${foodPreferenceValue!=null && foodPreferenceValue.equals("Regular")?"selected":""}>Regular</option>
		</select><span style="color:red">${foodPreferenceError}</span><br>			  	
		Drink:  RB <input type="checkbox" name="drink" value="rb" ${drinkValue.contains("rb")?"checked":""}/>
				MD <input type="checkbox" name="drink" value="md" ${drinkValue.contains("md")?"checked":""}/>
				TH <input type="checkbox" name="drink" value="th" ${drinkValue.contains("th")?"checked":""}/>
				LJ <input type="checkbox" name="drink" value="lj" ${drinkValue.contains("lj")?"checked":""}/>
				CO <input type="checkbox" name="drink" value="co" ${drinkValue.contains("co")?"checked":""}/>
				<span style="color:red">${drinkError}</span><br>
				<input type="submit" value="Register">
	</form>	
</body>
</html>