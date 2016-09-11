<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

  	<form name="editUser" method="POST" action="controller">
		<input type="hidden" name="command" value="edit_user" />
		First Name:<br><input type="text" name="firstName" value="${editUser.firstName}" required/><br/>
		Last Name:<br><input type="text" name="lastName" value="${editUser.lastName}" required/><br/>
		Email Address:<br><input type="text" name="email" value="${editUser.email}" required/><br/>
		Role:<br>
		<select name="role">
    		<option value="User"
    			<c:if test="${editUser.role eq 'USER'}">
    				selected
				</c:if> >User</option>
    		<option value="Administrator"
    			<c:if test="${editUser.role eq 'ADMINISTRATOR'}">
    				selected
				</c:if>	>Administrator</option>
	   </select><br/>
		<input type="submit" value="Save"/>
		
	</form>
	
	<form name="editPassword" method="POST" action="controller">
		<input type="hidden" name="command" value="edit_password_page" />
		<input type="hidden" name="email" value="${editUser.email}" />
		<input type="submit" value="Change password"/>
	</form>
	
	<form name="deleteUser" method="POST" action="controller">
		<input type="hidden" name="command" value="delete_user" />
		<input type="hidden" name="email" value="${editUser.email}" />
		<input type="submit" value="Delete user"/>
	</form>
	
	<c:forEach items="${errorFields}" var="entry">
    	<p>Field:  ${entry.key}. Error:  ${entry.value}</p>
	</c:forEach>
	
<jsp:include page="footer.jsp" />