<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
int num=111;

%>
<%
	String name=request.getParameter("uname");
    out.print(name);
%>
<br> <hr>
<%
out.print(num);
%>
<br> <hr>
Date is: <%= new Date() %>
<br> <hr>
</body>
</html>