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
String name=(String)application.getAttribute("app_name");
out.print(name+"<br>");
String iname=request.getParameter("iname");
double price=Double.parseDouble(request.getParameter("price"));

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root");
if(name.equals("pizza"))
{
	PreparedStatement ps=con.prepareStatement("insert into pizza values(?,?)");
	ps.setString(1, iname);
	ps.setDouble(2, price);
	int i=ps.executeUpdate();
	if(i==1)
	{
		out.print("Item Added Sucesfully<br>");
	}
}
if(name.equals("Burger"))
{
	PreparedStatement ps=con.prepareStatement("insert into Burger values(?,?)");
	ps.setString(1, iname);
	ps.setDouble(2, price);
	int i=ps.executeUpdate();
	if(i==1)
	{
		out.print("Item Added Sucesfully<br>");
	}
}
if(name.equals("veg"))
{
	PreparedStatement ps=con.prepareStatement("insert into veg values(?,?)");
	ps.setString(1, iname);
	ps.setDouble(2, price);
	int i=ps.executeUpdate();
	if(i==1)
	{
		out.print("Item Added Sucesfully<br>");
	}
}
if(name.equals("Non-veg"))
{
	PreparedStatement ps=con.prepareStatement("insert into non_veg values(?,?)");
	ps.setString(1, iname);
	ps.setDouble(2, price);
	int i=ps.executeUpdate();
	if(i==1)
	{
		out.print("Item Added Sucesfully<br>");
	}
}

%>
</body>
</html>