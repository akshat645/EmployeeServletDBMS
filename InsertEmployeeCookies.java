package ControllerEmployeeDAO;

import DAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author akshat
 */
public class InsertEmployeeCookies extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertEmployeeCookies</title>");            
            out.println("</head>");
            out.println("<body  background=b.jpg >");
            Cookie C[];
            C=request.getCookies();

            if(C!=null)
            {
                String uname,upass;
            uname=C[0].getValue();
            upass=C[1].getValue();
            if(LoginDAO.checkLogin(uname, upass))
            {
             out.println("<center><font color=\"black\" >   <a href=\"InsertEmployeeCookies\">Insert Employee</a>|||<a href=\"UpdateByID.html\">Update Employee By ID</a>|||<a href=\"SearchByID.html\">Search Employee By ID</a>|||<a href=\"SearchByDept.html\">Search Employee By dept</a>|||<a href=\"SearchByPhno.html\">Search Employee By Phno</a>|||<a href=\"DeleteByID.html\">Delete Employee By ID</a>|||<a href=\"SearchAll\">Search All</a>|||<a href=\"SingOut\">SINGOUT</a></font>\n" +
"         <br><br><br></center>");
                out.println(""
                    + "<center><font color=\"blue\">Employee Data Base Management</font>\n" +
"        <form method=\"post\" action=\"InsertEmployee\">    \n" +
"        <table border='1'> \n" +
"            \n" +
"            <tr>\n" +
"            <th>Name</th>\n" +
"            <td><input type=\"text\" name=\"txtname\"></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <th>Department</th>\n" +
"            <td><input type=\"text\" name=\"txtdept\"> </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <th>Salary</th>\n" +
"            <td><input type=\"number\" name=\"txtsalary\"></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <th>Phone number</th>\n" +
"            <td><input type=\"number\" name=\"txtphno\"></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <th>Set password</th>\n" +
"            <td><input type=\"password\" name=\"txtpassword\"></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td></td>\n" +
"            <td><input type=\"submit\" value=\"submit\">\n" +
"                <input type=\"reset\" value=\"reset\">\n" +
"                </td>\n" +
"        </tr>\n" +
"        </table>\n" +
"            </form>\n" +
"            </center>");
            }}
            else
            {
            out.println("<a href=Login.html>Session Expire</a>");
            }
            
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
