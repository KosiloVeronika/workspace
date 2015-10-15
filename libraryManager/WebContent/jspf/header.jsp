<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.info_messages" var="resourceBundle"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<header>
	    <div class="vladmaxi-top">
	        <c:choose>
	        	<c:when test="${user == null}">
		        	<ctg:locale-switch/>
			            <span class="right">
							<a href="<c:url value="/jsp/registration.jsp"/>">
			                	<strong><fmt:message key="lables.registration" bundle="${resourceBundle }"/></strong>
			            	</a>
			            	
			            </span>
				</c:when>
				<c:otherwise>
					<i:import url="/jspf/hello_user.jsp" />
				</c:otherwise>
	        </c:choose>
	    <div class="clr"></div>
	    </div>
	</header>
</body>
</html>