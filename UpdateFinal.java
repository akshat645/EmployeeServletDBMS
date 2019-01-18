
package ControllerEmployeeDAO;

import DAO.EmployeeDAO;
import DAO.LoginDAO;
import POJO.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akshat
 */
public class UpdateFinal extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();
        try {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateFinal</title>");            
            out.println("</head>");
            HttpSession session=request.getSession();
            String uname,upass;
            uname=(String)(session.getAttribute("user"));
            upass=(String)(session.getAttribute("pass"));
            if(LoginDAO.checkLogin(uname, upass))
            {
             out.println("<body background=b.jpg>");
            out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployee.html\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            int eid,salary;
            long phno;
            String name,dept;
            eid=Integer.parseInt(request.getParameter("txteid"));
            name=request.getParameter("txtname");
            dept=request.getParameter("txtdept");
            salary=Integer.parseInt(request.getParameter("txtsalary"));
            phno=Long.parseLong(request.getParameter("txtphno"));
            
            Employee E=new Employee();
            E.setEid(eid);
            E.setEname(name);
            E.setDept(dept);
            E.setSalary(salary);
            E.setPh_no(phno);
            EmployeeDAO Ed=new EmployeeDAO();
            if(Ed.updateData(E))
                out.println("Record Updated successfully");
            else
                out.println("Not Found");
            out.println("</body>");
            out.println("</html>");
        }
            else
            {
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
