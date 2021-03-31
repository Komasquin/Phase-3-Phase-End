<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Tasks</title>
</head>
<body>
<h1>Welcome to your list of tasks</h1>
<table>
		<tr><th>Task ID</th><th>Task Name</th><th>Description</th><th>Email</th><th>Start Date</th><th>End Date</th><th>Severity</th><th>User ID</th></tr>
		<c:forEach items="${tasks}" var="task" varStatus="count">
			<tr id="${count.index}">
				<td>${tasks.id}</td>
				<td>${tasks.name}</td>
				<td>${tasks.description}</td>
				<td>${tasks.email}</td>
				<td>${tasks.startDate}</td>
				<td>${tasks.endDate}</td>
				<td>${tasks.severity}</td>
				<td>${tasks.user}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>