package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uname=request.getParameter("uname");
//		String pass=request.getParameter("pass");
//		response.setContentType("text/html");
//		PrintWriter pw=response.getWriter();
//		String ps="admin";
//		int i=pass.compareTo(ps);
//		if(i==0)
//		{
//			pw.write("Welcome to our project "+"<strong>"+uname+"</strong>");
//		}
//		else
//		{
//			pw.write("<font color='Red'>");
//			pw.write("<strong>Check Password</strong>");
//			pw.write("</font>");
//			RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
//			rd.include(request, response);
//			
//		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String uname=request.getParameter("uname");
			String pass=request.getParameter("pass");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
			PreparedStatement ps=con.prepareStatement("select email from loginfo where email=? and password=?;");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pw.print("<h3>Successfull Login </h3>"+uname);
			}
			else
			{
				pw.write("<font color='Red'>");
				pw.print("<h3>Login failed wrong credentials </h3>");
				pw.write("</font>");
				RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
