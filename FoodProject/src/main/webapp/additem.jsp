<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="additem1.jsp">
Name: <input type="text" name="iname"><br> <br>
Price: <input type="text" name="price"> <br> <br>
<input type="submit" value="Submit">

</form>
<%
String name=request.getParameter("name");
application.setAttribute("app_name", name);
%>
</body>
</html>