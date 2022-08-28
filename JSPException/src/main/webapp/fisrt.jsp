<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int x=Integer.parseInt(request.getParameter("n1"));
int y=Integer.parseInt(request.getParameter("n2"));
%>
Div is:
<%= x/y %>
</body>
</html>