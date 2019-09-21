<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>show test</h1>
<%

%>
<%-- ${list["0"].content} --%>
<c:if test="${not empty list}">
	<ul>
		<c:forEach var="listValue" items="${list}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>
</c:if>

<c:if test="${not empty listGuest}">
	<ul>
		<c:forEach var="listValue" items="${listGuest}">
			<li>id:${listValue.name}, content : ${listValue.content}</li>
			<li>ggg</li>		
		</c:forEach>
	</ul>
</c:if>

listGuest
ggg112
</body>
</html>