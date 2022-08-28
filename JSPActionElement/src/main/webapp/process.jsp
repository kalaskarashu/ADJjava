 <%@page import= "p1.CapBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String n=request.getParameter("uname");
%>
<%
  	CapBean cap=new CapBean();
     cap.setWord(n); %>
<h2>
<%=cap.getWord()%>
</h2>
<p style="color:red; font-size:2rem;" >
<%=cap.getCap() %>
</p>
</body>
</html>