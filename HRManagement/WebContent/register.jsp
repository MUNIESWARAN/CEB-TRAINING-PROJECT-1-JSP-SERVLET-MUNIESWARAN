<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up Page</title>
</head>
<body>

	<h3>Welcome To Registration Page</h3>

	<br />

	<br />

	<form action="ValidationController" method="post">
		<br /> First Name: <input type="text" name="firstname" /><br />
		<br /> Last Name: <input type="text" name="lastname" /><br />
		<br /> Gender: <input type="radio" name="gender" value="male" checked>
		<br /> Male | <input type="radio" name="gender" value="female">Female<br />
		<br /> DATE OF BIRTH: <input type="text" placeholder="DD/MM/YYYY"
			required class="datepicker" name="dateofbirth" value=""
			pattern="\d{1,2}/\d{1,2}/\d{4}"
			onemptied="setCustomValidity('Please fill your DOB')" /> <br /> 
		<br />ADDRESS: 	<input type="text" name="commaddress" /><br /> 
		<br />EMAIL:<input type="email" name="emailid" /> <br /> 
		<br />PASSWORD:	<input type="password" name="password"/> <br />
		<br />CONTACT: <input type="text" name="contact"/><br />
		<br />Signup as:<select name="usertype">
			<option value="HR">HR</option>
			<option value="TRAINER">TRAINER</option>
			<option value="EMPLOYEE">EMPLOYEE</option>

		</select> <br /><br/><br/> <input type="submit">
	</form>

</body>
</html>