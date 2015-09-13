<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="welcome-file-list" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
    <div class="vladmaxi-top">
        <a href="http://vladmaxi.net" target="_blank">Главная</a>
        <span class="right">
        <a href="jsp/registration1.jsp">
                <strong>Регистрация</strong>
            </a>
        </span>
    <div class="clr"></div>
    </div>

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
</body>
</html>