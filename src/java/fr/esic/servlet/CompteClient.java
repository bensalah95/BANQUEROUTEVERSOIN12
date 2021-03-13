
package fr.esic.servlet;

import fr.esic.dao.CompteDao;
import fr.esic.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marye
 */
@WebServlet(name = "CompteClient", urlPatterns = {"/CompteClient"})
public class CompteClient extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CompteClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompteClient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
         User user =(User) session.getAttribute("user");
        
    
    }
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
