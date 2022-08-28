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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public registerServlet() {
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
		String fname=request.getParameter("fn");
		String lname=request.getParameter("ln");
		String ename=request.getParameter("en");
		String pass=request.getParameter("ps");
		String dob=request.getParameter("dob");
		String phone=request.getParameter("ph");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
		PreparedStatement ps=con.prepareStatement("insert into loginfo (First_name,Last_name,Email,Password,DoB,Phone) values(?,?,?,?,?,?)");
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, ename);
		ps.setString(4, pass);
		ps.setString(5, dob);
		ps.setString(6, phone);
		int i=ps.executeUpdate();
		if(i==1)
		{
			pw.print("<h3>Successfully Registration"+fname+"</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
			rd.include(request, response);
			
			
		}
		else
		{
			pw.print("<h3>Registration Failed</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			rd.include(request, response);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
