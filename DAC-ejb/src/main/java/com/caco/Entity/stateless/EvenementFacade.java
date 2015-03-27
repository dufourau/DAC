/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Categorie;
import com.caco.Entity.Evenement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andreiy
 */
@Stateless
public class EvenementFacade extends AbstractFacade<Evenement> implements EvenementFacadeLocal {
    
    private static final Logger LOGGER = LogManager.getLogger(EvenementFacade.class);
    
    @PersistenceContext(unitName = "com.caco_DAC-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvenementFacade() {
        super(Evenement.class);
    }

    @Override
    public void createFromMap(Map<String, Object> evenement) {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        try {
            createFromParam(
                    (String) evenement.get("nom"),
                    (Date) formatter.parse(((String)evenement.get("date"))), 
                    (String) evenement.get("ville"),
                    (double) evenement.get("prix"),
                    Categorie.fromString((String) evenement.get("categorie")),
                    (int) evenement.get("quantite")
            );
        } catch (java.lang.ClassCastException e){
            LOGGER.error("Error while loading Evenement : "
                    + evenement.get("nom") + "\n" + e.getMessage());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(EvenementFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createFromParam(String nom, Date date, String lieu, double prix, Categorie categorie, int quantiteInitiale) {
        Evenement e = new Evenement(nom, date, lieu, prix, categorie, quantiteInitiale);
        create(e);
    }

    @Override
    public void removeAll() {
        LOGGER.warn("Removing all rows from table Evenement");
        int deletedCount = em.createQuery("DELETE FROM Evenement").executeUpdate();
        LOGGER.warn("Deleted " + deletedCount + "rows from Evenement");
    }
    
    @Override
    public List<Evenement> findEvents(String nom, Date date, String ville, double prixMin, double prixMax, String categorie) {
        String request = "SELECT events FROM Evenement AS events "
                + "where LOWER(events.nom) like LOWER(:nom) AND "
                + "LOWER(events.lieu) like LOWER(:ville) AND "
                + "events.prix >= :prixMin AND events.prix <= :prixMax AND "
                + "events.date >= :date";
        
        //si l'utilisateur cherche une catégorie spécifique
        if(!categorie.equals("TOUTES")){  
            request += " AND events.categorie = :cat";
        }
        
        //Création de la requête et set des paramètres
        Query req = em.createQuery(request);
        req = req.setParameter("nom", "%"+nom+"%");
        req = req.setParameter("ville", "%"+ville+"%");
        req = req.setParameter("prixMin", prixMin);
        req = req.setParameter("prixMax", prixMax);
        req = req.setParameter("date", date);
        if(!categorie.equals("TOUTES")){
            req = req.setParameter("cat", Categorie.fromString(categorie));
        }
        
        return req.getResultList();
    }
    
}
