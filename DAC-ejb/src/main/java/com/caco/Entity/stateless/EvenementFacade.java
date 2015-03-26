/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Evenement;
import java.util.List;
import java.util.Map;
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
        try {
            createFromParam(
                    (String) evenement.get("nom"),
                    (String) evenement.get("date"), 
                    (String) evenement.get("ville"),
                    (double) evenement.get("prix")
            );
        } catch (java.lang.ClassCastException e){
            LOGGER.error("Error while loading Evenement : "
                    + evenement.get("nom") + "\n" + e.getMessage());
        }
    }

    @Override
    public void createFromParam(String nom, String date, String ville, double prix) {
        Evenement e = new Evenement(nom, date, ville, prix);
        create(e);
    }

    @Override
    public void removeAll() {
        LOGGER.warn("Removing all rows from table Evenement");
        int deletedCount = em.createQuery("DELETE FROM Evenement").executeUpdate();
        LOGGER.warn("Deleted " + deletedCount + "rows from Evenement");
    }
    
    @Override
    public List<Evenement> findEvents(String nom, String date, String ville, double prixMin, double prixMax) {
        String request = "SELECT events FROM Evenement AS events where events.nom=:nom";
        Query req = em.createQuery(request);
        req = req.setParameter("nom", nom);
        return req.getResultList();
    }
    
}
