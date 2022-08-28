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

@WebServlet("/logInServlet")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logInServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String username=request.getParameter("uname");
			String pass=request.getParameter("pass");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
			PreparedStatement ps=con.prepareStatement("select * from loginfo where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			pw.print("<a href=loginform.html>login</a> ");
			pw.print("<a href=profileServlet>Profile</a> ");
			pw.print("<a href=deleteServlet>Delete Profile</a> ");
			pw.print("<a href=UpdateServlet>Update profile</a> ");
			pw.print("<a href=logoutServlet>Logout</a>");
			HttpSession session=request.getSession();
			if(rs.next())
			{
				pw.print("<h3>Succesfully Login</h3>");
				session.setAttribute("session_val", username);
			}
			else
			{
				pw.print("<h3>Login Error</h3><br>");
				pw.print("<h3>Register yourself</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
