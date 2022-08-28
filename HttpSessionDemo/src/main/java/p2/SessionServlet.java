package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		Integer accesscount=null;
		accesscount=(Integer)session.getAttribute("accesscnt");
		if(accesscount ==null)
		{
			accesscount=0;
		}
		else
		{
			accesscount=new Integer (accesscount+1);
		}
		session.setAttribute("accesscnt", accesscount);
		session.setMaxInactiveInterval(30);
		pw.print("<html>");

		pw.print(" You Visited This Servlet Access Count +   " + accesscount + "<br>");

		pw.print("<hr>");
		pw.print(" Session ID +   " + session.getId() + "<br>");

		pw.print("<hr>");
		pw.print(" Session Creation Time  +   " + new Date(session.getCreationTime()) + "<br>");

		pw.print("<hr>");
		pw.print(" Session Last Time  +   " + new Date(session.getLastAccessedTime()) + "<br>");

		pw.print("<hr>");
		pw.print(" Session Max Time  +   " + session.getMaxInactiveInterval() + "<br>");

		pw.print("</html>");

	}

}
