<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Create a Match</title>
</head>
<body>
	<form:form action="create" method="POST">
		<div>
			<label>Date:</label>
			<input id="date" name="date" type="date">
		</div>
		<div>
			<label>Start Time:</label>
			<input id="startTime" name="startTime" type="time">
		</div>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>