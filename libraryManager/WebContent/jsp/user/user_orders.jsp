<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.info_messages" var="resourceBundle"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<meta http-equiv="welcome-file-list" content="text/html; charset=utf-8">
	<title>registration</title>
</head>
<body>
<c:import url="/jspf/header.jsp" />
	<table border="1">
		<td><tr>${errorOrderMessage }</td></tr>
		<tr>
				<td><fmt:message key="order.id" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="order.book" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="order.st" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="order.cancel" bundle="${resourceBundle }"/></td>
			</tr>
		<c:forEach var="order" items="${orders }">
			<tr>
				<td><c:out value="${order.orderID }"></c:out></td>
				<td><c:out value="${order.book.bookName }"></c:out></td>
				<td><c:out value="${order.st}"></c:out></td>
				
				<td>
					<form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            		<input type="hidden" name="command" value="add" />
	            		<input type="hidden" name="book_id" value="<c:out value="${book.bookID }"></c:out>" />
	            		<input type="submit" value="<fmt:message key="order.button.cancel" bundle="${resourceBundle}"/>">
            		</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>