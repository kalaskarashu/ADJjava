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
String fn=request.getParameter("fname");
String ln=request.getParameter("lname");
String en=request.getParameter("ename");
String pass=request.getParameter("pass");
String gender=request.getParameter("gender");
String rt=request.getParameter("rt");
String rname=request.getParameter("rname");
String services=request.getParameter("service");
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root");
PreparedStatement ps=con.prepareStatement("insert into restaurant (First_Name,Last_Name,Email,Password,gender,Restaurant_Type,Services,Restaurant_name) values(?,?,?,?,?,?,?,?)");
ps.setString(1, fn);
ps.setString(2, ln);
ps.setString(3, en);
ps.setString(4, pass);
ps.setString(5, gender);
ps.setString(6, rt);
ps.setString(7, services);
ps.setString(8, rname);
int i=ps.executeUpdate();
if(i==1)
{
	out.print("Resister Sucessfully");
}
else{
	out.print("Try Again");
}




%>
</body>
</html>