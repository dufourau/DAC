/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.Personne;
import com.caco.Entity.stateless.PersonneFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author dufourau
 */
public class Payment extends HttpServlet {
    
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    List<String> errors = new ArrayList<>();
    List<String> infos = new ArrayList<>();
    boolean success = true;
    Personne currentUser;
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Personne user = null;
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("username") != null){
            user = personneFacade.find(session.getAttribute("username"));
        }
        
        if (user != null && user.getPanier().getNbReservation() == 0){
           errors = new ArrayList<>();
           errors.add("Ajoutez d'abord des articles à votre panier !");
           request.setAttribute("errors", errors);
           request.getRequestDispatcher("/Index").forward(request, response);
           return;
        }

        session.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        
        if (session.getAttribute("username") != null){
            currentUser = personneFacade.find(session.getAttribute("username"));
        }
        
        session.setAttribute("user", currentUser);
        
        if (currentUser != null){
            currentUser.getPanier().update();
            personneFacade.edit(currentUser);
        } else {
            request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
            return;
        }
            
        
        doPayment(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Index servlet";
    }// </editor-fold>
    
    private void doPayment(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        errors = new ArrayList<>();
        infos = new ArrayList<>();
        success = true;
        if(request.getParameter("prenom") != null && request.getParameter("nom") != null && request.getParameter("codepostal") != null && request.getParameter("ville") !=null && request.getParameter("adresse")!=null){
            
            String prenom = request.getParameter("prenom");
            if(prenom.isEmpty()){
                errors.add("Veuillez renseigner un prenom.");
                success = false;
            }
            String nom = request.getParameter("nom");
            if(prenom.isEmpty()){
                errors.add("Veuillez renseigner un nom.");
                success = false;
            }
            String codepostal = request.getParameter("codepostal");
            int cp;
            try {
                cp = Integer.parseInt(codepostal);
            } catch (NumberFormatException e){
                errors.add("Le codepostal ne représente pas un nombre valide.");
                success = false;
            }
            String ville = request.getParameter("ville");
            if(ville.isEmpty()){
                errors.add("Veuillez renseigner une ville.");
                success = false;
            }
            String adresse = request.getParameter("adresse");
            if(adresse.isEmpty()){
                errors.add("Veuillez renseigner un adresse.");
                success = false;
            }
            String gender = request.getParameter("gender");
            String proprietaire = request.getParameter("proprietaire");
            String numerodecarte = request.getParameter("numerodecarte");
            String date = request.getParameter("date");
            String crypto = request.getParameter("crypto");
            if(gender == null || gender.isEmpty() ){
                errors.add("Veuillez renseigner un type de carte");
                success = false;
            }
            if(proprietaire == null || proprietaire.isEmpty() ){
                errors.add("Veuillez renseigner un nom de propriétaire");
                success = false;
            }
            if(date == null || date.isEmpty() ){
                errors.add("Veuillez renseigner une date");
                success = false;
            }
            int num;
            try {
                num = Integer.parseInt(numerodecarte);
            } catch (NumberFormatException e){
                errors.add("Le numéro de carte ne représente pas un nombre valide.");
                success = false;
            }
            int crypt;
            try {
                crypt = Integer.parseInt(crypto);
            } catch (NumberFormatException e){
                errors.add("Le cryptogramme ne représente pas un nombre valide.");
                success = false;
            }
            
            
            
        }else{
            errors.add("Veuillez compléter tous les champs");
            success = false;
            
        }
        
        if (success){
            currentUser.doPayment();
            personneFacade.edit(currentUser);
            infos.add("Les évenements ont bien été payés.");
            
        }
        
        if (errors ==null || errors.isEmpty()) errors = null;
        if (infos ==null || infos.isEmpty()) infos = null;
        
        if (success){
            request.setAttribute("infos", infos);
        } else {
            request.setAttribute("errors", errors);
        }
        getServletContext().getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
    }

}
