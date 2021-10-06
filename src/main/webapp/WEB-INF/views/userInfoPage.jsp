<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h1>Hello User: ${user}
</h1>

<h3>Persons List</h3>
<c:if test="${!empty studentRecord}">
	<table class="tg">
	<tr>
		<th width="80">Student ID</th>
		<th width="80">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">User Name</th>
	</tr>
	<c:forEach items="${studentRecord}" var="r">
		<tr>
			<td>${r.sid}</td>
			<td>${r.firstname}</td>
			<td>${r.lastname}</td>
			<td>${r.user.username}</td>
			<td><a href="<c:url value='/edit?id=${r.sid}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${r.sid}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>