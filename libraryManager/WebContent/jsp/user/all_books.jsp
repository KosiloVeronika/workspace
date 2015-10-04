<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="book" items="${books }">
			<tr>
				<td><c:out value="${book.getBookID() }"></c:out></td>
				<td><c:out value="${book.getBookName() }"></c:out></td>
				<td><c:out value="${book.getBookAuthor().getSurname() }"></c:out></td>
				<td><c:out value="${book.getBookAuthor().getName()} "></c:out></td>
				<td><c:out value="${book.getBookAuthor().getSecondName() }"></c:out></td>
				<td><c:out value="${book.getPublicationDate() }"></c:out></td>
				<td><c:out value="${book.getSection().getName() }"></c:out></td>
				<td><c:out value="${book.getIsAvalible() }"></c:out></td>
				<td><c:out value="${book.getNumberOfPages() }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>