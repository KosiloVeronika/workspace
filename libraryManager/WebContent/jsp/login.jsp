<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<form name="loginForm" method="POST" action="${pageContext.servletContext.contextPath}/Controller">
		<input type="hidden" name="command" value="login" />
		Login:<br/>
		<input type="text" name="login" value="admin"/>
		<br/>Password:<br/>
		<input type="password" name="password" value="123"/>
		<br/>
			${errorLoginPassMessage}
		<br/>
			${wrongAction}
		<br/>
 		<input type="submit" value="Log in"/>
	</form><hr/>
</body>
</html>