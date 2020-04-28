<!DOCTYPE html>
<html>
<head>
	<title>Hello World - Input Form</title>
</head>

<body>
	<form action="${pageContext.request.contextPath}/hello/processFormVersionThree" method="GET">
		<label>
			<input type="text" name="studentName" placeholder="What's your name?" />
		</label>

		<input type="submit" />
	</form>
</body>

</html>