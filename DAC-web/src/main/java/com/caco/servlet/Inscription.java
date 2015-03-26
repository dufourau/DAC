/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.servlet;

import com.caco.Entity.stateless.PersonneFacadeLocal;
import com.caco.Init;
import com.caco.Validation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andreiy
 */
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       
        getServletContext().getRequestDispatcher("/subscribe.jsp").forward(request, response);
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
        
        List<String> errors = new ArrayList<>();
        List<String> infos = new ArrayList<>();
        
        boolean success = true;
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        int age = 0;
        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException e){
            if (!request.getParameter("age").isEmpty()){
                errors.add("Le mot de passe doit contenir au moins une majuscule");
                success = false;
            }
        }
        String adresse = request.getParameter("adresse");
        
        if (!email.matches(Validation.EMAIL_PATTERN)){
            errors.add("Format d'adresse e-mail invalide");
            success = false;
        }
        
        if (password.length() < 7){
            errors.add("Le mot de passe doit être long d'au moins 7 caractères");
            success = false;
        }
        
        if (!password.matches(Validation.PASSWORD_PATTERN)){
            errors.add("Le mot de passe doit contenir au moins une majuscule");
            success = false;
        }
        
        if (!password.equals(password2)){
            errors.add("Les mots de passes ne coïncident pas");
            success = false;
        }
       
        if (success) {
            infos.add("Inscription réussie");
        }

        if (errors.isEmpty()) errors = null;
        if (infos.isEmpty()) infos = null;
        
        request.setAttribute("errors", errors);
        request.setAttribute("infos", infos);
        
        if (success){
            personneFacade.createFromParam(email, prenom, nom, password, age, adresse);
            LOGGER.info("Created user : " + email);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/subscribe.jsp").forward(request, response);
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
