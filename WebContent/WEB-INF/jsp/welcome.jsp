<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="welcome">Welcome <c:out value="${user.firstName}"/>. You are <c:out value="${user.role}"/>.</p>
<p><a href="controller?command=logout">Logout</a></p>
<c:if test="${user.role eq 'ADMINISTRATOR'}">
	<a href="controller?command=registration_page">Add user</a><br>
	<a href="controller?command=users_list_page">View users list</a>
</c:if>
