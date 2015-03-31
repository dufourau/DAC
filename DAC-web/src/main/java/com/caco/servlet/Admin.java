/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.Categorie;
import com.caco.Entity.Evenement;
import com.caco.Entity.PasPresenteException;
import com.caco.Entity.Personne;
import com.caco.Entity.Reservation;
import com.caco.Entity.stateless.EvenementFacadeLocal;
import com.caco.Entity.stateless.PanierFacade;
import com.caco.Entity.stateless.PanierFacadeLocal;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import com.caco.Init;
import com.caco.Validation;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
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
public class Admin extends HttpServlet {

    @EJB
    private EvenementFacadeLocal evenementFacade;
    
    private PanierFacadeLocal panierFacade;
    
    @EJB
    private PersonneFacadeLocal personneFacade;

    
    private static final Logger LOGGER = LogManager.getLogger(Init.class);

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
        Personne user = null;
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("username") != null){
            user = personneFacade.find(session.getAttribute("username"));
        }
            
        session.setAttribute("user",user);
        
        getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
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
        if (request.getParameter("operation") != null && request.getParameter("operation").equals("add")){
            addEvent(request, response);
        } else if (request.getParameter("operation") != null &&  request.getParameter("operation").equals("remove")){
            removeEvent(request, response);
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("Les paramètres de la requête sont invalides.");
            request.setAttribute("errors", errors);
            doGet(request, response);
        }
    }

    
    private void addEvent(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        List<String> errors = new ArrayList<>();
        List<String> infos = new ArrayList<>();
        
        boolean success = true;
        
        String titre = request.getParameter("titre");
        Date date = null;
        String lieu = request.getParameter("lieu");
        double prix = 0;
        Categorie categorie = null;
        int nombreTickets = 0;
        String description = request.getParameter("description");
        
        if (request.getParameter("nombreTickets") != null){
            try {
                nombreTickets = Integer.parseInt(request.getParameter("nombreTickets"));
            } catch (NumberFormatException e){
                errors.add("Le nombre de ticket ne représente pas un entier valide.");
                success = false;
            }
        } else {
            errors.add("Veuillez ajouter un nombre de ticket.");
            success = false;
        }
        
        if (request.getParameter("prix") != null){
            try {
                prix = Double.parseDouble(request.getParameter("prix"));
            } catch (NumberFormatException e){
                errors.add("Le prix ne représente pas un nombre valide.");
                success = false;
            }
        } else {
            errors.add("Veuillez ajouter un prix.");
            success = false;
        }
        
        if (titre == null || titre.isEmpty()){
            errors.add("Veuillez renseigner un titre.");
            success = false;
        }
        
        if (lieu == null || lieu.isEmpty()){
            errors.add("Veuillez renseigner un lieu.");
            success = false;
        }
        
        if (description == null || description.isEmpty()){
            errors.add("Veuillez renseigner une description.");
            success = false;
        }
        
        if (request.getParameter("categorie") == null || request.getParameter("categorie").isEmpty()){
            errors.add("Veuillez renseigner une catégorie.");
            success = false;
        } else {
            categorie = Categorie.fromString(request.getParameter("categorie"));
            if (categorie == null){
                errors.add("Veuillez renseigner une catégorie.");
                success = false;
            }
        }

        if (request.getParameter("date") != null){
            SimpleDateFormat formatter = new SimpleDateFormat(Validation.DATE_FORMAT);
            try {
                date = formatter.parse(request.getParameter("date"));
            } catch (ParseException ex) {
                errors.add("Format de date invalide");
                success = false;
            }
        } else {
            errors.add("Veuillez ajouter une date pour l'évènement");
            success = false;
        }

        if (success){
            evenementFacade.createFromParam(titre, date, lieu, prix, categorie, nombreTickets);
            infos.add("L'évenement " + titre + " a bien été créé.");
            LOGGER.info("Create new event " + titre);
        }
        
        if (errors.isEmpty()) errors = null;
        if (infos.isEmpty()) infos = null;
        
        if (success){
            request.setAttribute("infos", infos);
        } else {
            request.setAttribute("errors", errors);
        }
        doGet(request, response);
        
    }
    
    private void removeEvent(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        List<String> errors = new ArrayList<>();
        List<String> infos = new ArrayList<>();
        
        boolean success = true;
        
        String titre = request.getParameter("titre");
        
        if (titre.isEmpty()){
            errors.add("Veuillez renseigner un titre.");
            success = false;
        }
        
        try {
            panierFacade = (PanierFacadeLocal) new InitialContext().lookup("java:app/ejb/PanierFacade");
        } catch (NamingException ex) {
            errors.add("Erreur interne au serveur.");
            success = false;
        }
        
        if (success){
            List<Evenement>  events = evenementFacade.findEvents(titre);
            for (Evenement e : events){
                for (Reservation r : e.getReservations()){
                    try {
                        r.getPanier().removeReservation(r);
                    } catch (PasPresenteException ex) {
                    }
                    panierFacade.edit(r.getPanier());
                }
            }
            evenementFacade.remove(titre);
            infos.add("L'évenement " + titre + " a été supprimé.");
            LOGGER.info("Create new event " + titre);
        }
        
        if (errors.isEmpty()) errors = null;
        if (infos.isEmpty()) infos = null;
        
        if (success){
            request.setAttribute("infos", infos);
        } else {
            request.setAttribute("errors", errors);
        }
        doGet(request, response);
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
