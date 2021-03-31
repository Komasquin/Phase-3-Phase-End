<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Task</title>
</head>
<body>
<h1>Delete A Task</h1>
	<form action="delete" method="post">
		<label for="id">Task ID:</label><br>
       		 <input type="text" id="id" name="id"><br>
  		<input type="submit" value="Submit">
  	</form>
</body>
</html>