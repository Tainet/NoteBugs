<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>NoteBug</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<c:choose>
    <c:when test="${user.role eq 'GUEST'|| empty user.role }">
        <jsp:include page="login.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="welcome.jsp" />
    </c:otherwise>
	</c:choose>
	
	
	<p class="errorMsg"><c:out value="${errorMessage}"/></p>