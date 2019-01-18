package ControllerEmployeeDAO;

import DAO.EmployeeDAO;
import POJO.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<body background=b.jpg> <center><font color=\"black\" > <a href=\"LoginChoice.html\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            int eid;
            eid=Integer.parseInt(request.getParameter("txteid"));
            String password;
            password=request.getParameter("txtpassword");
            EmployeeDAO a=new EmployeeDAO();
            Employee E1=new Employee();
            E1.setEid(eid);
            Employee E=new Employee();
            E=a.search_By_eid(E1);
            
            if(password.equals(E.getPassword()))
            {out.println("<center><h1>Hello "+E.getEname()+"</center></h1>");
            out.println("<center><table border=1>");
            String id=Integer.toString(eid);
                   out.println("<center><form method=post action=UpdateFinal2><br><br><br><br><br><br><br><br><br><h3>Employee Details<h3><table border=1>");
            out.println("<tr><th>Employee ID</th><th>"+E.getEid()+"</th></tr>");
            HttpSession session=request.getSession(true);
            session.setAttribute("eid",id);
           
            out.println("<tr><th>Employee Name</th><th>"+"<input type=text name=txtname value="+E.getEname()+"></th></tr>");
            out.println("<tr><th>Employee Department</th><th>"+"<input type=text name=txtdept value="+E.getDept()+"></th></tr>");
            out.println("<tr><th>Employee Salary</th><th>"+"<input type=number name=txtsalary value="+E.getSalary()+"></th></tr>");
            out.println("<tr><th>Employee Phone number</th><th>"+"<input type=number name=txtphno value="+E.getPh_no()+"></th></tr>");
            out.println("<tr><td></td><td><input type=submit value=Update><input type=reset value=reset></td></tr>");
            out.println("</table></center>");
            
            }
            else
                response.sendRedirect("Login.html");
            
            out.println("</body>");
            out.println("</html>");
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
