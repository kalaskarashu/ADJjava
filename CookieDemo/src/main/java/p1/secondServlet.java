package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondServlet")
public class secondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public secondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<b>Cookie</b><br>");
		
		Cookie[] ck=request.getCookies();
		
		for (int i = 0; i < ck.length; i++) {
			pw.print("Name:"+ck[i].getName()+"<br>");
			pw.print("Value:"+ck[i].getValue());
		}
		RequestDispatcher rd=request.getRequestDispatcher("Index.html");
		rd.include(request, response);
	}

}
