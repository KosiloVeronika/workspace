<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.info_messages" var="resourceBundle"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value="/css/style.css" />" rel="stylesheet" media="screen" type="text/css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/js/validation.js"/>"></script>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><fmt:message key="lables.authorization" bundle="${resourceBundle}"/></title>
</head>
<body>
	<c:import url="/jspf/header.jsp" />
    <div id="login-form">
      <h1><fmt:message key="lables.header1" bundle="${resourceBundle}"/></h1>
        <fieldset>
            <form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            <input type="hidden" name="command" value="login" />
	                <input type="text" name="login" placeholder="<fmt:message key="placeholder.login" bundle="${resourceBundle}"/>"> 
	                <input type="password" name="password" placeholder="<fmt:message key="placeholder.password" bundle="${resourceBundle}"/>"> 
	                <input type="submit" value="<fmt:message key="button.enter" bundle="${resourceBundle}"/>">
	                <br/>
					${errorLoginPassMessage}
				<br/>
					${wrongAction}
				<br/>
            </form>
        </fieldset>
    </div> 
	<c:import url="/jspf/footer.jsp" />
</body>
</html>