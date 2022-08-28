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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		pw.write("Hi my First name is "+"<strong>"+fn+"</strong>");
//		pw.write(" and Last name is "+"<strong>"+ln+"</strong>");
//		pw.write("<br>");
//		pw.write("Email id is "+"<strong>"+en+"</strong>");
//		pw.write(" PassWord "+"<strong>"+ps+"</strong>");
//		pw.write("<br>");
//		pw.write(" DoB "+"<strong>"+dob+"</strong>");
//		pw.write(" Phone number is  "+"<strong>"+ph+"</strong>");
//		pw.write("<br>");pw.write("<br>");
//		pw.write("<h3>Registration Complete</h3>");
//		pw.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String fn=request.getParameter("fn");
			String ln=request.getParameter("ln");
			String en=request.getParameter("en");
			String ps=request.getParameter("ps");
			String dob=request.getParameter("dob");
			String ph=request.getParameter("ph");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
			PreparedStatement pres=con.prepareStatement("insert into loginfo values(?,?,?,?,?,?)");
			pres.setString(1,fn);
			pres.setString(2,ln);
			pres.setString(3,en);
			pres.setString(4,ps);
			pres.setString(5,ph);
			pres.setString(6,dob);
			int i=pres.executeUpdate();
			if(i==1)
			{
				pw.print("<h3>Successfully Registration</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("loginform.html");
				rd.include(request, response);
			}
			else
			{
				pw.print("<h3>Not Successfully Registration</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
