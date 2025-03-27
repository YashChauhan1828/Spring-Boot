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
		Student Name: <input type="text" name="studentName"/><span style="color:red">${studentNameError}</span><br>
		Playing Type: Batsman <input type="radio" name="playerType" value="Batsman"/>
					  Bowler <input type="radio" name="playerType" value="Bowler"/>
					  All Rounder <input type="radio" name="playerType" value="AllRounder"/>
					  <span style="color:red">${playerTypeError}</span><br>
		Food Preference:
		<select name="foodPreference">
			<option value="-1">Select your Food Preference</option>
			<option value="Jain">Jain</option>
			<option value="Regular">Regular</option>
		</select><span style="color:red">${foodPreferenceError}</span><br>			  	
		Drink:  RB <input type="checkbox" name="drink" value="rb"/>
				MD <input type="checkbox" name="drink" value="md"/>
				TH <input type="checkbox" name="drink" value="th"/>
				LJ <input type="checkbox" name="drink" value="lj"/>
				CO <input type="checkbox" name="drink" value="co"/><br>
				<input type="submit" value="Register">
	</form>	
</body>
</html>