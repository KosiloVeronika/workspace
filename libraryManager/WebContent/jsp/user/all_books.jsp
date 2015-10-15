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
<title></title>
</head>
<body>

	<c:import url="/jspf/header.jsp" />
	<table border="1">
		<tr>${errorOrderMessage }</tr>
		<tr>
				<td><fmt:message key="table.id" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.name" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.author" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.publication" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.section" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.pages" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.avalible" bundle="${resourceBundle }"/></td>
				<td><fmt:message key="table.order" bundle="${resourceBundle }"/></td>
			</tr>
		<c:forEach var="book" items="${books }">
			<tr>
				<td><c:out value="${book.bookID }"></c:out></td>
				<td><c:out value="${book.bookName }"></c:out></td>
				<td><c:out value="${book.getBookAuthor().surname }"></c:out>
					<c:out value="${book.getBookAuthor().name } "></c:out>
					<c:out value="${book.getBookAuthor().secondName }"></c:out></td>
				<td><c:out value="${book.publicationDate }"></c:out></td>
				<td><c:out value="${book.getSection().name }"></c:out></td>
				<td><c:out value="${book.isAvalible }"></c:out></td>
				<td><c:out value="${book.numberOfPages }"></c:out></td>
				<td>
					<form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            		<input type="hidden" name="command" value="add" />
	            		<input type="hidden" name="book_id" value="<c:out value="${book.bookID }"></c:out>" />
	            		<input type="radio" name="st" value="ON_HANDS" /><fmt:message key="table.statmentH" bundle="${resourceBundle}"/>
	            		<input type="radio" name="st" value="IN_READING_ROOM" /><fmt:message key="table.statmentRR" bundle="${resourceBundle}"/>
						<input type="submit" value="<fmt:message key="table.order" bundle="${resourceBundle}"/>">
            		</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>