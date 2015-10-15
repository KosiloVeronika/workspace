<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="<c:url value="/js/validation_reg.js"/>"></script>
	<link href="<c:url value="/css/style.css" />" rel="stylesheet" media="screen" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<title>registration</title>
</head>
<body>
	<c:import url="/jspf/header.jsp" />
	<table border="1">
		<tr>${errorOrderMessage }</tr>
		
		<tr>
				<td>Действие</td>
				<td>Ф.И.О</td>
				<td>Дата рождения</td>
				<td>Серия паспорта</td>
				<td>Номер паспорта</td>
				<td>Кем вадан</td>
				<td>Дата выдачи</td>
				<td>Идентификационный номер</td>
				<td>Место рождения</td>
				<td>Город(Факт проживания)</td>
				<td>Адрес</td>
				<td>Дом. Тел.</td>
				<td>Моб.Тел.</td>
				<td>E-mail</td>
				<td>Место работы</td>
				<td>Должность</td>
				<td>Адрес прописки</td>
				<td>Семейное положение</td>
				<td>Гражданство</td>
				<td>Ивалидность</td>
				<td>Пенсионер</td>
				<td>Ежемесячный доход</td>
			</tr>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>
					<form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            		<input type="hidden" name="command" value="delete" />
	            		<input type="hidden" name="user_id" value="<c:out value="${user.userID }"></c:out>" />
						<input type="submit" value="Удалить">
            		</form>
            		<form method="POST" action="${pageContext.servletContext.contextPath}/Controller">
	            		<input type="hidden" name="command" value="change_page" />
	            		<input type="hidden" name="user_id" value="<c:out value="${user.userID }"></c:out>" />
						<input type="submit" value="Изменить">
            		</form>
				</td>
				<td><c:out value="${user.surname }"></c:out>
					<c:out value="${user.name } "></c:out>
					<c:out value="${user.secondName }"></c:out></td>
				<td><c:out value="${user.dateOfBirth }"></c:out></td>
				<td><c:out value="${user.passportSeries }"></c:out></td>
				<td><c:out value="${user.passportNumber }"></c:out></td>
				<td><c:out value="${user.authority }"></c:out></td>
				<td><c:out value="${user.dateOfIssue }"></c:out></td>
				<td><c:out value="${user.identification_number }"></c:out></td>
				
				<td><c:out value="${user.birthPlace }"></c:out></td>
				<td><c:out value="${user.city.city }"></c:out></td>
				
				<td><c:out value="${user.address }"></c:out></td>
				<td><c:out value="${user.homeTelephone }"></c:out></td>
				<td><c:out value="${user.mobileTelephone }"></c:out></td>
				<td><c:out value="${user.email }"></c:out></td>
				<td><c:out value="${user.placeOfWork }"></c:out></td>
				
				<td><c:out value="${user.wPosition }"></c:out></td>
				<td><c:out value="${user.registrationAddress }"></c:out></td>
				
				<td><c:out value="${user.maritalStatus.status }"></c:out></td>
				<td><c:out value="${user.citizenship.citizenship }"></c:out></td>
				
				<td><c:out value="${user.disability.disability }"></c:out></td>
				<td><c:out value="${user.isPensioner }"></c:out></td>
				<td><c:out value="${user.monthlyIncome }"></c:out></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>