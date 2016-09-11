<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />

	
	<table>
	<tr>
    	<th>
    		<c:choose>
  				<c:when test="${sort eq 'firstname' && direction eq 'asc'}">
    				<a href="controller?command=users_list_page&sort=firstnamedesc">First Name</a>
				</c:when>
  				<c:otherwise>
    				<a href="controller?command=users_list_page&sort=firstname">First Name</a>
  				</c:otherwise>
			</c:choose>
    	</th>
    	<th>
    		<c:choose>
  				<c:when test="${sort eq 'lastname' && direction eq 'asc'}">
    				<a href="controller?command=users_list_page&sort=lastnamedesc">Last Name</a>
				</c:when>
  				<c:otherwise>
    				<a href="controller?command=users_list_page&sort=lastname">Last Name</a>
  				</c:otherwise>
			</c:choose>
    	</th> 
    	<th>
    		<c:choose>
  				<c:when test="${sort eq 'email' && direction eq 'asc'}">
    				<a href="controller?command=users_list_page&sort=emaildesc">Email</a>
				</c:when>
  				<c:otherwise>
    				<a href="controller?command=users_list_page&sort=email">Email</a>
  				</c:otherwise>
			</c:choose>
    	</th>
    	<th>
    		<c:choose>
  				<c:when test="${sort eq 'role' && direction eq 'asc'}">
    				<a href="controller?command=users_list_page&sort=roledesc">Role</a>
				</c:when>
  				<c:otherwise>
    				<a href="controller?command=users_list_page&sort=role">Role</a>
  				</c:otherwise>
			</c:choose>
    		
    	</th>
  	</tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td><a href="controller?command=edit_user_page&email=<c:out value='${user.email}'/>">${user.firstName}</a>  </td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
	</table>

	<c:set var='pagination' value='&sort=${sort}' />
	<c:if test="${direction eq 'desc'}">
		<c:set var='pagination' value='${pagination}${direction}' />
	</c:if>

	
	<c:if test="${previousPage eq 'true'}">
		<a href="controller?command=previous_users_page<c:out value='${pagination}'/>">Previous</a>
	</c:if>
	<br>
	<c:if test="${nextPage eq 'true'}">
		<a href="controller?command=next_users_page<c:out value='${pagination}'/>">Next</a><br>
	</c:if>
	
	
<jsp:include page="footer.jsp" />