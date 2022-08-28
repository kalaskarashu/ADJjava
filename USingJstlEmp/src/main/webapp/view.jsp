<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
border: 1px solid black;
border-collapse: collapse;
}
td,th{
border: 1px solid black;
}
</style>
</head>
<body>

<table>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Role</th>
</tr>
</thead>
<tbody>
			<c:forEach items="${requestScope.empList}" var="emp">
				<tr>
					<td><c:out value="${emp.id }"></c:out></td>
					<td><c:out value="${emp.name }"></c:out></td>
					<td><c:out value="${emp.role }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
</table>
</body>
</html>