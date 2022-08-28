package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp=new Employee();
		emp.setId(11);
		emp.setName("Ashutosh");
		emp.setRole("Learner");
		Employee emp2=new Employee();
		emp2.setId(22);
		emp2.setName("Chetan");
		emp2.setRole("Learner");
		ArrayList<Employee> empList=new ArrayList<Employee>();
		empList.add(emp);
		empList.add(emp2);
		request.setAttribute("empList", empList);
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
	}

}
