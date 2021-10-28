/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiants;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Etudiant;

/**
 *
 * @author Mohamed
 */
@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

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
        String login=request.getParameter("login");
        String mdp=request.getParameter("mdp");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Connexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Connexion at " + request.getContextPath() + "</h1>");
            out.println("<h1>Vos paramètres de connexion sont:</h1>");
            out.println("<h2>Login: "+login+"</h2>");
            out.println("<h2>Mot de passe: "+mdp+"</h2>");
            Etudiant e=new Etudiant();
            //creation d'une session:
            
            
            if(e.connexion(login, mdp)){
                out.println("<h2>nom: "+e.nom+"</h2>");
                out.println("<h2>prenom: "+e.prenom+"</h2>");
            }else{
                out.println("<h2>Connexion impossible !!!!</h2>");
            }
            HttpSession session= request.getSession();
            
            //mise en session d'un objet etudiant:
            session.setAttribute("Etudiant",e);
            
            //recuperation de l'objet:
            
            response.sendRedirect("etudiants/espaceMembere.jsp");
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
