<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

  	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="registration2" />
		First Name:<br><input type="text" name="firstName" value="" required/><br/>
		Last Name:<br><input type="text" name="lastName" value="" required/><br/>
		Email Address:<br><input type="text" name="email" value="" required/><br/>
		Role:<br>
		<select name="role">
    		<option value="User" selected>User</option>
    		<option value="Administrator">Administrator</option>
	   </select><br/>
		Password:<br><input type="password" name="password" value="" required/><br/>
		Password Confirmation:<br><input type="password" name="passwordConfirmation" value="" required/><br/>
		<input type="submit" value="register"/>
		
	</form>
	
	<c:forEach items="${errorFields}" var="entry">
    	<p>Field:  ${entry.key}. Error:  ${entry.value}</p>
	</c:forEach>
	
<jsp:include page="footer.jsp" />