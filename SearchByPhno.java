package ControllerEmployeeDAO;

import DAO.EmployeeDAO;
import DAO.LoginDAO;
import POJO.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SearchByPhno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        try {
            HttpSession session=request.getSession();
            String uname,upass;
            uname=(String)(session.getAttribute("user"));
            upass=(String)(session.getAttribute("pass"));
            if(LoginDAO.checkLogin(uname,upass))
            {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByID</title>");            
            out.println("</head>");
            out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployee.html\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            long phno;
            phno=Long.parseLong(request.getParameter("txtphno"));
            Employee E=new Employee();
            E.setPh_no(phno);
            EmployeeDAO Ed=new EmployeeDAO();
            
            E=Ed.search_By_Ph_No(E);
            out.println("<center><br><br><br><br><br><br><br><br><br><h3>Employee Details<h3><table border=1>");
            out.println("<tr><th>Employee Id</th><th>"+ E.getEid()+"</th></tr>");
            out.println("<tr><th>Employee Name</th><th>"+ E.getEname()+"</th></tr>");
            out.println("<tr><th>Employee Department</th><th>"+ E.getDept()+"</th></tr>");
            out.println("<tr><th>Employee Salary</th><th>"+ E.getSalary()+"</th></tr>");
            out.println("<tr><th>Employee Phone Number</th><th>"+ E.getPh_no()+"</th></tr>");
            out.println("</table></center>");
            out.println("</body>");
            out.println("</html>");
        }
            else{
            response.sendRedirect("LoginChoice.html");
            }
        }
        catch(Exception E)
        {
        out.println(E);
        }
         
    
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
  @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
