/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.Evenement;
import com.caco.Entity.stateless.EvenementFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andreiy
 */
public class SearchEvent extends HttpServlet {
    
    @EJB    
    private EvenementFacadeLocal evenementFacade;
     
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
       /* response.setContentType("text/html;charset=UTF-8");
        String nom = request.getParameter("nom");
        
        System.err.println("----");
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements())
        { 
            String t = e.nextElement();
            System.err.print(t + " : " + request.getParameter(t));
        }*/
        
        //Recherche d'événements
        String nom = request.getParameter("nom");
        String date = request.getParameter("date");
        String ville = request.getParameter("ville");
        String prixMin = request.getParameter("prixMin");
        String prixMax = request.getParameter("prixMax");
        System.err.println("SearchEvent");
        List<Evenement> evenements = evenementFacade.findEvents(nom, date, ville, Double.parseDouble(prixMin), Double.parseDouble(prixMax));
        for(Evenement e : evenements){
            System.err.println(e.getNom());
        }
        request.setAttribute("evenements", evenements);
        getServletContext().getRequestDispatcher("/vue.jsp").forward(request, response);
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
