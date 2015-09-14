<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value="/css/style.css" />" rel="stylesheet" media="screen" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>login</title>
</head>
<body>
	<c:import url="/jspf/header.jsp" />
    <div id="login-form">
      <h1>АВТОРИЗАЦИЯ</h1>
        <fieldset>
            <form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            <input type="hidden" name="command" value="login" />
	                <input type="text" name="login" required value="Логин" onBlur="if(this.value=='')this.value='Логин'" onFocus="if(this.value=='Логин')this.value='' "> 
	                <input type="password" name="password" required value="Пароль" onBlur="if(this.value=='')this.value='Пароль'" onFocus="if(this.value=='Пароль')this.value='' "> 
	                <input type="submit" value="ВОЙТИ">
	                <br/>
					${errorLoginPassMessage}
				<br/>
					${wrongAction}
				<br/>
            </form>
        </fieldset>
    </div> 
	hello web-app!

	<a href="jsp/login.jsp">LogIn</a>
	
	<a href="jsp/registration.jsp">Register</a>
	<c:import url="/jspf/footer.jsp" />
</body>
</html>