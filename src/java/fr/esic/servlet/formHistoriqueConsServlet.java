/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.servlet;

import fr.esic.dao.ConseillerDao;
import fr.esic.dao.HistoriqueConsDao;
import fr.esic.dao.PersonDao;
import fr.esic.model.HistoriqueCons;
import fr.esic.model.Person;
import fr.esic.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nathan Ghozlan
 */
@WebServlet(name = "formHistoriqueConsServlet", urlPatterns = {"/formHistoriqueCons"})
public class formHistoriqueConsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formHistoriqueConsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet formHistoriqueConsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                List<HistoriqueCons> histCons = HistoriqueConsDao.getAllHistorique();

                request.setAttribute("hist", histCons);
                
                request.getRequestDispatcher("WEB-INF/formHistoriqueConseiller.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.println("expt :" + e.getMessage());
            }

        } else {
            request.setAttribute("msg", "tu n'es pas connecter");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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

        try {
            // A mettre ds le post de formhistCons (a creer)
            String userId = request.getParameter("userId");
            int idU = Integer.parseInt(userId);

            String login = request.getParameter("login");
            String password = request.getParameter("mdp");

            String statut = request.getParameter("statut");
            System.out.println("stat: " + statut);
            int stat = Integer.parseInt(statut);

            Person pe = PersonDao.getPersonById(idU);
            System.out.println("person: " + pe);

            User c = new User(login, password, pe, stat);
            c.setId(idU);
            String label = null;
            if (stat == 1) {
                //label = c.getPerson().getPrenom() + " " + c.getPerson().getNom() + " a activé le compte N° " + userId;
                label = "le compte n°" + userId + " a été activé";
            } else {
                //label = c.getPerson().getPrenom() + " " + c.getPerson().getNom() + " a desactivé le compte N° " + userId;
                label = "le compte n°" + userId + " a été desactivé";

            }
            HistoriqueConsDao.getInstance().newHistorique(new HistoriqueCons(-1, label, c.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(formHistoriqueConsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
