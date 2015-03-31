/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.PasPresenteException;
import com.caco.Entity.Personne;
import com.caco.Entity.Reservation;
import com.caco.Entity.stateless.EvenementFacadeLocal;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import com.caco.Entity.stateless.ReservationFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dufourau
 */
@WebServlet(name = "RetirerPanier", urlPatterns = {"/RetirerPanier"})
public class RetirerPanier extends HttpServlet {
    
    @EJB    
    private ReservationFacadeLocal reservationFacade;
        
    @EJB
    private PersonneFacadeLocal personneFacade;
    
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
        List<String> errors = new ArrayList<>();
        List<String> infos = new ArrayList<>();
                
        String idInput = request.getParameter("id");
        
        boolean failed = false;
        
        int numberOfTickets = 0;
        Reservation reservation = null;
        
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            failed = true;
            errors.add("Vous devez être connecté pour pouvoir retirer une "
                    + "réservation de votre panier");
            request.setAttribute("errors", errors);
        
            getServletContext().getRequestDispatcher("/Panier").forward(request, response);
            return;
        }
        
        Personne currentUser = null;
       
        if (session.getAttribute("username") != null){
            currentUser = personneFacade.find(((Personne)(session.getAttribute("user"))).getEmail());
        }
            
        request.setAttribute("user", currentUser);
        
        long id = Long.valueOf(idInput);
        
        reservation = reservationFacade.find(id);
        
        if (reservation == null){
            failed = true;
            errors.add("Cette réservation n'existe pas.");
        }
        
        if (failed){
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/Index").forward(request, response);
            return;
        }
        
        try {
            currentUser.retirerDuPanier(reservation);
        } catch (PasPresenteException e) {
            errors.add("Désolé, " + e.getEvenement().getNom() + " n'est pas présente dans votre panier");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/Index").forward(request, response);
            return;
        }
        System.out.println(reservation.getEvenement());
        personneFacade.edit(currentUser);
        evenementFacade.edit(reservation.getEvenement());
        
        infos.add("La réservation de l'évenement " + reservation.getEvenement().getNom() + " a bien été retiré de "
                + "vote panier");
        
        request.setAttribute("infos", infos);
        
        getServletContext().getRequestDispatcher("/Panier").forward(request, response);
    
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
