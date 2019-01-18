package ControllerEmployeeDAO;

import DAO.EmployeeDAO;
import DAO.LoginDAO;
import POJO.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SearchByDept extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session=request.getSession();
            String uname,upass;
            uname=(String)(session.getAttribute("user"));
            upass=(String)(session.getAttribute("pass"));
            if(LoginDAO.checkLogin(uname,upass))
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByDept</title>");            
            out.println("</head>");
            out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployee.html\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            String dept;
            dept=request.getParameter("txtdept");
            Employee E=new Employee();
            E.setDept(dept);
            EmployeeDAO Ed=new EmployeeDAO();
            List<Employee> l=null;
            l=Ed.search_By_dept(E);
            int i=0;
            out.println("<center><br><br><br><br><br><h3>Employee Details<h3><table border=1>");
            out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee Department</th><th>Employee Salary</th><th>Employee Phone Number</th></tr>");
            while(l.size()!=i)
            {
            E=l.get(i);
            out.println("<tr><th>"+ E.getEid()+"</th>");
            out.println("<th>"+ E.getEname()+"</th>");
            out.println("<th>"+ E.getDept()+"</th>");
            out.println("<th>"+ E.getSalary()+"</th>");
            out.println("<th>"+ E.getPh_no()+"</th>");
            out.println("</tr>");
            i++;
            }
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
