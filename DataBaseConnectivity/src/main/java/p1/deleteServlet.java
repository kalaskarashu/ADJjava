package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		int i=(int)session.getAttribute("session_id");
		pw.print("<a href=loginform.html>login</a> ");
		pw.print("<a href=profileServlet>Profile</a> ");
		pw.print("<a href=deleteServlet>Delete Profile</a> ");
		pw.print("<a href=Update.html>Update profile</a> ");
		pw.print("<a href=logoutServlet>Logout</a><br>");
			
		if(session != null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				String fname=request.getParameter("fname");
				String lname=request.getParameter("lname");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
				PreparedStatement ps=con.prepareStatement("delete from loginfo where id=?");
				ps.setInt(1, i);
				int p=ps.executeUpdate();
				if(p==1)
				{
					pw.print("Profile Delete Sucessfully");
				}
				else
				{
					pw.print("Not sucessful");
				}
				}				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		
				else 
				{
					pw.print("Login Agian");
					RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
					rd.include(request, response);
				}
			
		}
	}


	


