<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<form action="addAlien">
			<input type = "text" name="aid"><br>
			<input type = "text" name="aname"><br>
			<input type = "text" name="tech"><br>
			<input type = "submit" value="Add Alien"><br>
		</form>
		
		<form action="getAlien">
			<input type = "text" name="aid"><br>
			<input type = "submit" value="Get Alien"><br>
		</form>
		
		<form action="getAllAliens">
			<input type = "submit" value="Get All Aliens"><br>
		</form> 
		
		<form action="updateAlien">
			<input type = "text" name="aid"><br>
			<input type = "text" name="aname"><br>
			<input type = "text" name="tech"><br>
			<input type = "submit" value="Update Alien"><br>
		</form>
		
</body>
</html>