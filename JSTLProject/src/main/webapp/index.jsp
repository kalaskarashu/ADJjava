<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL</h1>
<c:out value="${'Ashutosh' }"></c:out>
<br>
<c:set var="num" value="1000"></c:set>
<c:out value="${num}"></c:out>
<br> <hr>
<c:if test="${num>500 }">
<c:out value="${'Number is greater' }"></c:out>
</c:if>
<hr>
<c:choose>
<c:when test="${num<1200 }">
<c:out value="${'Number is Samller' }"></c:out>
</c:when>
<c:otherwise>
<c:out value="${'Number is Greater' }"></c:out>
</c:otherwise>
</c:choose>
<br>
<hr>
<c:forEach var="i" begin="1" end="5">
<b><c:out value="${i}"></c:out></b><br>
</c:forEach>
<hr>
<p style="color:red; font-size:1.3rem;">
<c:forTokens items="I-love-india-and-best-country-in-the-world" delims="-" var="name">
<c:out value="${name }"></c:out>
</c:forTokens>
</p>
</body>
</html>