<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
	    <div class="vladmaxi-top">
	        <a href="http://vladmaxi.net" target="_blank">Главная</a>
	        <span class="right">
	        <c:choose>
	        	<c:when test="${user == null}">
					<a href="jsp/registration.jsp">
	                	<strong>Регистрация</strong>
	            	</a>
				</c:when>
				<c:otherwise>
					<i:import url="/jspf/hello_user.jsp" />
				</c:otherwise>
	        </c:choose>
	        </span>
	    <div class="clr"></div>
	    </div>
	</header>
</body>
</html>