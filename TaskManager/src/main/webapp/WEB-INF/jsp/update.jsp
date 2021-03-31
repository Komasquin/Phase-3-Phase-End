<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Tasks</title>
</head>
<body>
<h1>Update A Task</h1>
<form action="update" method="post">
		<label for="id">Task ID:</label><br>
 	    <input type="text" id="id" name="id"><br>
		<label for="fname">Task name:</label><br>
 	    <input type="text" id="fname" name="fname"><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email"><br>
        <label for="sdate">Start Date:</label><br>
        <input type="date" id="sdate" name="sdate"><br>
        <label for="edate">End Date:</label><br>
        <input type="date" id="edate" name="edate"><br>
        <label for="desc">Description:</label><br>
        <textarea id="desc" name="desc" rows=10 cols=30></textarea><br>
       		 <label for="sev">Severity</label><br>
  				<select id="sev" name="sev">
  					<option value="high">High</option>
  					<option value="medium">Medium</option>
  					<option value="low">Low</option>
  				</select>
  			<br>
  		<label for="user_id">User ID:</label><br>
        <input type="text" id="user_id" name="user_id"><br>
  		<input type="submit" value="Submit">

	</form>
</body>
</html>