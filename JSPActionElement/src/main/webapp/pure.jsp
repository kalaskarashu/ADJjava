<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="p1.CapBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cp" class="p1.CapBean"></jsp:useBean>
<jsp:setProperty property="word" name="cp" param="uname"/>
<jsp:getProperty property="word" name="cp"/>
<br>
<%=cp.getCap() %> <br>
<%=cp.getLow() %>
</body>
</html>