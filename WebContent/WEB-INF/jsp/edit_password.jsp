<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

  	<form name="editPassword" method="POST" action="controller">
		<input type="hidden" name="command" value="edit_password" />
		<input type="hidden" name="email" value="${email}" />
		New password:<br><input type="password" name="password" value="" required/><br/>
		New password confirmation:<br><input type="password" name="passwordConfirmation" value="" required/><br/>
		<input type="submit" value="Save"/>
	</form>
	
	<c:forEach items="${errorFields}" var="entry">
    	<p>Field:  ${entry.key}. Error:  ${entry.value}</p>
	</c:forEach>
	
<jsp:include page="footer.jsp" />