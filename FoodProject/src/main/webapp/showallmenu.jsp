<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root");
PreparedStatement ps=con.prepareStatement("select * from pizza,burger,veg,non_veg");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
		out.println(rs.getString(1));
		out.println(rs.getInt(2));
}
%>
</body>
</html>