<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="C:/Users/Veronika/workspace/libraryManager/WebContent/css/style.css" media="screen" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>main</title>
</head>
<body>
    <div class="vladmaxi-top">
        <a href="http://vladmaxi.net" target="_blank">Главная</a>
        <span class="right">
        <a href="jsp/registration.jsp">
                <strong>Регистрация</strong>
            </a>
        </span>
    <div class="clr"></div>
    </div>
	<div id="login-form">
		<h1>Регистрация</h1>
			<fieldset>
				<form method="post" action="${pageContext.servletContext.contextPath}/Controller">
					<input type="email" name="mail" required value="e-mail" onBlur="if(this.value=='')this.value='e-mail'" onFocus="if(this.value=='e-mail')this.value=''">
			        <input type="text" name="username" required value="Логин" onBlur="if(this.value=='')this.value='Логин'" onFocus="if(this.value=='Логин')this.value=''">
			        <input type="password" name="password" required value="Пароль" onBlur="if(this.value=='')this.value='Пароль'" onFocus="if(this.value=='Пароль')this.value=''" >
			        <input type="submit" name="command" value="registration">
			        <input type="reset" value="Reset">
			        <a href="login.jsp">Login Here</a>
			        <br/>
						${errorRegistrationPassMessage}
					<br/>
						${wrongAction}
					<br/>
				</form>
			</fieldset>
	</div>
</body>
</html>