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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static boolean isDateValid(String date) 
    {
        String DATE_FORMAT = "dd/mm/yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
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
        try {  
            String PRICE_MATCHER = "\\d+\\.\\d";
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            
            //Récupération des paramètres et formatage des données
            String nom = request.getParameter("nom");
            Date date;
            String ville = request.getParameter("ville");
            String prixMin = request.getParameter("prixMin");
            String prixMax = request.getParameter("prixMax");
            String categorie = request.getParameter("categorie");
            double prixMinD = 0.0;
            double prixMaxD = 1000000000.0;
            boolean isPrixMin = prixMin.matches(PRICE_MATCHER);
            boolean isPrixMax = prixMax.matches(PRICE_MATCHER);
            
            if(isDateValid(request.getParameter("date"))){
                date = formatter.parse(request.getParameter("date")); 
            }
            else{
                date = formatter.parse("01/01/1970");
            }
            
            if(!prixMin.equals("") && isPrixMin){
                prixMinD = Double.parseDouble(prixMin);
            }
            
            if(!prixMax.equals("") && isPrixMax){
                prixMaxD = Double.parseDouble(prixMax);
            }
            
            //Récupération des données
            List<Evenement> evenements = evenementFacade.findEvents(nom, date, ville, prixMinD, prixMaxD, categorie);
            
            //Redirection sur la bonne page
            request.setAttribute("evenements", evenements);
            getServletContext().getRequestDispatcher("/jsp/resultatRecherche.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SearchEvent.class.getName()).log(Level.SEVERE, null, ex);
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
