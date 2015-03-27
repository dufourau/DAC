/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.Evenement;
import com.caco.Entity.Personne;
import com.caco.Entity.Reservation;
import com.caco.Entity.RuptureDeStockException;
import com.caco.Entity.stateless.EvenementFacadeLocal;
import com.caco.Entity.stateless.PersonneFacadeLocal;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pouzaudr
 */
@WebServlet(name = "AjouterPanier", urlPatterns = {"/AjouterPanier"})
public class AjouterPanier extends HttpServlet {
    
    private static final Logger LOGGER = LogManager.getLogger(DetailsEvent.class);

    @EJB    
    private EvenementFacadeLocal evenementFacade;
        
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
        
        List<String> errors = new ArrayList<>();
        List<String> infos = new ArrayList<>();
                
        String idInput = request.getParameter("id");
        String numberOfTicketsInput = request.getParameter("number");
        
        boolean failed = false;
        
        int numberOfTickets = 0;
        Evenement evenement = null;
        
        long id;
        try {
            id = Long.valueOf(idInput);
            evenement = evenementFacade.find(id);
        } catch (NumberFormatException e) {
            failed = true;
            errors.add("Cet évènement n'existe pas.");
            return;
        }
        
        try {
            numberOfTickets = Integer.valueOf(numberOfTicketsInput);
        } catch (NumberFormatException e) {
            failed = true;
            errors.add("Nombre de ticket invalide.");
        }
        

        
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null){
            failed = true;
            errors.add("Vous devez être connecté pour pouvoir ajouter un "
                    + "élément à votre panier");
        }
        
        if (failed){
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/Index").forward(request, response);
            return;
        }
        
        Personne currentUser = (Personne) session.getAttribute("user");
        try {
            Reservation r = currentUser.ajouterAuPanier(new Reservation(evenement, numberOfTickets));
        } catch (RuptureDeStockException e) {
            errors.add("Désolé, il ne reste plus " + e.getQuantiteDemandee() + " places disponibles");
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/Index").forward(request, response);
            return;
        }
        
        personneFacade.edit(currentUser);
        
        infos.add("L'évenement " + evenement.getNom() + " a bien été ajouté à "
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
