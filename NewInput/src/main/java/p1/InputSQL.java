package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/InputSQL")
public class InputSQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InputSQL() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fn=request.getParameter("FirstName");
		String ln=request.getParameter("LastName");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginfo","root","root");
			PreparedStatement ps=con.prepareStatement("insert into log values(?,?)");
			ps.setString(1, fn);
			ps.setString(2, ln);
			int i=ps.executeUpdate();
			if(i==1)
			{
				pw.print("Sucessed");
			}
			else
			{
				pw.print("not succed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
