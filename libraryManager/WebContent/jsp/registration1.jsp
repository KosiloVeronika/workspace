<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</body>
</html>