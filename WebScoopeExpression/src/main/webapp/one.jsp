<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${param.uname }
<%
application.setAttribute("mobile", 123456);
%>
<a href="two.jsp">next</a>
</body>
</html>