package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public firstServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		HttpSession session=request.getSession();
		if(pass.equals("admin"))
		{
			pw.print("<h3>");
			pw.print("Session Id:"+session.getId());
			pw.print("<br>");
			pw.print("Session creation Time:"+new Date (session.getCreationTime()));
			pw.print("<br>");
			pw.print("Session Last Assesed Time:"+new Date (session.getLastAccessedTime()));
			pw.print("<br>");
			pw.print("</h3>");
			session.setAttribute("Session_val", name);
			session.setMaxInactiveInterval(30);
			pw.print("<a href='index.html'>Login page</a> &nbps;<a href='ProfileServlet'>Profile</a> &nbps;<a href='LogoutServlet'>LogOut</a><br>");
		}
		else
		{
			pw.print("Login Failed");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
