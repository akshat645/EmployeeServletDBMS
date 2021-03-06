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
public class UpdateByID extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByID</title>");            
            out.println("</head>");
            HttpSession session=request.getSession();
            String uname,upass;
            uname=(String)(session.getAttribute("user"));
            upass=(String)(session.getAttribute("pass"));
            if(LoginDAO.checkLogin(uname, upass))
            {
             out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployee.html\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            int eid;
            eid=Integer.parseInt(request.getParameter("txteid"));
            Employee E=new Employee();
            E.setEid(eid);
            EmployeeDAO Ed=new EmployeeDAO();
            E=Ed.search_By_eid(E);
            out.println("<center><form method=post action=UpdateFinal><br><br><br><br><br><br><br><br><br><h3>Employee Details<h3><table border=1>");
            out.println("<tr><th>Employee ID</th><th>"+"<input type=text name=txteid value="+E.getEid()+"></th></tr>");
           
            out.println("<tr><th>Employee Name</th><th>"+"<input type=text name=txtname value="+E.getEname()+"></th></tr>");
            out.println("<tr><th>Employee Department</th><th>"+"<input type=text name=txtdept value="+E.getDept()+"></th></tr>");
            out.println("<tr><th>Employee Salary</th><th>"+"<input type=number name=txtsalary value="+E.getSalary()+"></th></tr>");
            out.println("<tr><th>Employee Phone number</th><th>"+"<input type=number name=txtphno value="+E.getPh_no()+"></th></tr>");
            out.println("<tr><td></td><td><input type=submit value=Update><input type=reset value=reset></td></tr>");
           
            out.println("</table></center>");
            out.println("</body>");
            
        }
            else
            {
            response.sendRedirect("LoginChoice.html");
            
            }
            out.println("</html>");
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
