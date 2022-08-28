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
import javax.servlet.http.HttpSession;

@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public profileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		pw.print("<a href=loginform.html>login</a> ");
		pw.print("<a href=profileServlet>Profile</a> ");
		pw.print("<a href=deleteServlet>Delete Profile</a> ");
		pw.print("<a href=Update.html>Update profile</a> ");
		pw.print("<a href=logoutServlet>Logout</a><br>");
		 if(session !=null)
		 {
			 
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
			 } catch (ClassNotFoundException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
				 PreparedStatement ps=con.prepareStatement("select * from loginfo where email=?");
				 String name=(String)session.getAttribute("session_val");
				 ps.setString(1, name);
				 ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 pw.print("Name:");
					 pw.print(rs.getString(1));
					 pw.print("<br>");
					 pw.print("Last Name:");				
					 pw.print(rs.getString(2));
					 pw.print("<br>");
					 pw.print("Email:");				
					 pw.print(rs.getString(3));
					 pw.print("<br>");
					 pw.print("Phone:");				
					 pw.print(rs.getString(5));
					 pw.print("<br>");
					 pw.print("DoB:");				
					 pw.print(rs.getString(6));
					 pw.print("<br>");
					 pw.print("ID:");				
					 pw.print(rs.getInt(7));
					 pw.print("<br>");
					 int i=rs.getInt(7);
					 session.setAttribute("session_id",i);
					 
				 }
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
		 }
		 else
		 {
			pw.print("Please login again");
			RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
			rd.include(request, response);
		 }
    }

}

