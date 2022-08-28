package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//don't forget to conmment
//@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public firstServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	String name=request.getParameter("uname");
	pw.print("<b>"+name+"</b>");
	//initialize param
	ServletConfig config=getServletConfig();
	String num=config.getInitParameter("mobile");
	pw.print("<hr>");
	pw.print("<b>"+num+"</b>");
	pw.print("<hr>");
	ServletContext cont=getServletContext();
	String home=cont.getInitParameter("Google");
	pw.print("<b>"+home+"</b>");
	
	
	
	}

}
