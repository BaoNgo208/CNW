<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html">
<title>Login page</title>
</head>
<body>
	
	<form action="CheckLoginServlet" method="post">
		Username: <input type="text" name="userName" />
		Password: <input type="text" name="password" />
		<input type="submit" value="Login" />
		
	</form>
</body>
</html>