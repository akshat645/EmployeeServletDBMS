package ControllerEmployeeDAO;

import DAO.EmployeeDAO;
import POJO.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.LoginDAO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
public class LoginAdmin extends HttpServlet {
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
            out.println("<body background=b.jpg> <center><font color=\"black\" >   <a href=\"InsertEmployee.html\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"LoginChoice.html\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
            String  username;
            username=request.getParameter("txtadmin");
            String password;
            password=request.getParameter("txtpassword");
            HttpSession session=request.getSession(true);
            session.setAttribute("user",username);
            session.setAttribute("pass",password);
            
            if(LoginDAO.checkLogin(username, password))
            {
                out.println("<center><h1>Hello ADMIN "+"</center></h1>");
         
            }
            else
                response.sendRedirect("AdminLogin.html");
            
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
