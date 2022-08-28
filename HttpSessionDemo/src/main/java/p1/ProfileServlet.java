package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProfileServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		pw.print("<a href='index.html'>Login page</a> &nbps;<a href='ProfileServlet'>Profile</a> &nbps;<a href='LogoutServlet'>LogOut</a><br>");
		
		if(session != null)
		{
			String name=(String)session.getAttribute("Session_val");
			pw.print("<h3>");
			pw.print("Welcome "+name);
			pw.print("</h3>");
		}
		else
		{
			pw.print("<br><b>Please Login Again</b>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
