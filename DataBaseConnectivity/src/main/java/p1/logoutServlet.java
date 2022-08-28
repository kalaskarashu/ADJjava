package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logoutServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<a href=loginform.html>login</a> ");
		pw.print("<a href=profileServlet>Profile</a> ");
		pw.print("<a href=deleteServlet>Delete Profile</a> ");
		pw.print("<a href=UpdateServlet>Update profile</a> ");
		pw.print("<a href=logoutServlet>Logout</a><br>");
		HttpSession session=request.getSession(false);
		session.invalidate();
		pw.print("Logout Successfully");
	
	
	}

	

}
