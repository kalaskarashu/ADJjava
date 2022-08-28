package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
//@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String fn;
    String ln;
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		fn=request.getParameter("FirstName");
		ln=request.getParameter("LastName");
		//String ps=request.getParameter("Pass");
		pw.print("<h2>");
		pw.print(fn.toUpperCase());
		pw.print("</h2>");
		pw.print("<br>");
		pw.print("<h3>");
		pw.print(ln.toUpperCase());
		pw.print("</h3>");
		pw.print("<br>");
		//pw.print(ps);
		RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
		rd.include(request, response);
		
	}

}
