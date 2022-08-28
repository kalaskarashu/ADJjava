package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String pass=request.getParameter("upass");
		pw.print("<b>"+name+"</b><br>");
		pw.print("<b>"+pass+"</b>");
		
		pw.print("<form action='secondServlet' method='get'>");
		
		pw.print("<input type='hidden' name='uname' value='"+name+"'>");
		pw.print("<input type='hidden' name='upass' value='"+pass+"'>");
		pw.print("<input type='submit' value='next'>");
		
		
		pw.print("</form>");
		pw.print("<a href='secondServlet?uname="+name+"&upass="+pass+"'>Next</a>");
	}

}
