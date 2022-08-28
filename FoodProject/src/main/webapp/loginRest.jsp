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
<a href="additem.html"><button>AddItem</button></a>
<a href="profile.jsp"><button>Profile</button></a>
<a href="showallmenu.jsp"><button>ShowAll Menu</button></a>
<br> <br>
<hr>
<%
String en=request.getParameter("uname");
String pass=request.getParameter("pass");
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root");
PreparedStatement ps=con.prepareStatement("select * from restaurant where email=? and password=?");
ps.setString(1,en);
ps.setString(2,pass);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	out.print("Login Sucesseful");
}
else{
	out.print("Login Again");
}




%>
</body>
</html>