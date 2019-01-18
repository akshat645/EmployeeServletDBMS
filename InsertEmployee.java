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
public class InsertEmployee extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            HttpSession session=request.getSession();
            String uname,upass;
            uname=(String)(session.getAttribute("user"));
            upass=(String)(session.getAttribute("pass"));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertEmployee</title>");            
            out.println("</head>");
            if(LoginDAO.checkLogin(uname, upass))
            {
            out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployeeCookies\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            int salary;
            long phno;
            String name,dept,password;
            name=request.getParameter("txtname");
            dept=request.getParameter("txtdept");
            salary=Integer.parseInt(request.getParameter("txtsalary"));
            phno=Long.parseLong(request.getParameter("txtphno"));
            password=request.getParameter("txtpassword");
            Employee E=new Employee();
            EmployeeDAO Ed=new EmployeeDAO();
            int a=Ed.last_ID();
            E.setEid(++a);
            E.setEname(name);
            E.setDept(dept);
            E.setPh_no(phno);
            E.setSalary(salary);
            E.setPassword(password);
            if(Ed.insertData(E))
            {
            out.println("<center><table border=1>");
            out.println("<tr><th>Eid</th>"+"<th>"+Ed.last_ID()+"</th></tr>");
            out.println("<tr><th>Name</th>"+"<th>"+name+"</th></tr>");
            out.println("<tr><th>Department</th>"+"<th>"+dept+"</th></tr>");
            out.println("<tr><th>Salary</th>"+"<th>"+salary+"</th></tr>");
            out.println("<tr><th>Phone number</th>"+"<th>"+phno+"</th></tr>");
            out.println("</table></center>");
            }
            else
                out.println("not");
            out.println("</body>");
            
            }
            else
            {
            out.println("<body background=b.jpg>");
            response.sendRedirect("AdminLogin.html");
            }
            
            out.println("</html>");
        } 
        catch(Exception e)
        {out.println(e);} 
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
