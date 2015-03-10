/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.Personne;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andreiy
 */
@WebServlet(name = "Inscription2", urlPatterns = {"/Inscription2"})
public class Inscription2 extends HttpServlet {
    @EJB
    private PersonneFacadeLocal personneFacade;
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
        
        String pwd = request.getParameter("password");
        String pwd2 = request.getParameter("password2");
        String email = request.getParameter("email");
        
        if(pwd.equals(pwd2)){
       
            /*String email = request.getParameter("email");
            String prenom = request.getParameter("prenom");
            //int age = Integer.parseInt(request.getParameter("age"));
            int age = 120;
            String nom = request.getParameter("nom");
            String adresse = request.getParameter("adresse");*/

            personneFacade.createFromParam(email, "unknown", "unknown", pwd, 100, "unknown");
            
            List<Personne>  listPers = personneFacade.findAll();
        
            System.err.print("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            
            for (Iterator<Personne> iterator = listPers.iterator(); iterator.hasNext();) {
                Personne next = iterator.next();
                System.err.print("ID de la personne : ");
                System.err.print(next.getId());
            }
            
            request.setAttribute("logger", true);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
