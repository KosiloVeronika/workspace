<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.info_messages" var="resourceBundle"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
        <a href="Controller?command=logout">
                <strong><fmt:message key="lables.exit" bundle="${resourceBundle}"/></strong>
            </a>
        
        <strong>${user}, <fmt:message key="message.hello" bundle="${resourceBundle }"/></strong>
</body>
</html>