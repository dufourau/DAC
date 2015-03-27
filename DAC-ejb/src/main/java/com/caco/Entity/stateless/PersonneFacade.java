/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Personne;
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
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    
    private static final Logger LOGGER = LogManager.getLogger(PersonneFacade.class);

    @PersistenceContext(unitName = "com.caco_DAC-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }

    @Override
    public void createFromNom(String nom) {
        Personne p = new Personne();
        p.setNom(nom);
        create(p);
    }
    
    @Override
    public void createFromParam(String email, String prenom, String nom, String password, int age, String adresse){
        Personne p = new Personne(email,prenom,nom,password, age,adresse);
        create(p);
    }
        
    @Override
    public void createFromMap(Map<String, Object> personne){
        createFromParam(
                (String) personne.get("email"),
                (String) personne.get("prenom"), 
                (String) personne.get("nom"),
                (String) personne.get("password"),
                (int) personne.get("age"),
                (String) personne.get("adresse")
        );
    }

    @Override
    public void removeAll() {
        LOGGER.warn("Removing all rows from table Personne");
        int deletedCount = em.createQuery("DELETE FROM Personne").executeUpdate();
        LOGGER.warn("Deleted " + deletedCount + "rows from Personne");
    }

    @Override
    public Personne find(String email, String password) {
        String request = "SELECT p FROM Personne AS p "
                + "where p.email = :email AND p.password = :password";
        Query req = em.createQuery(request, Personne.class);
        req = req.setParameter("email", email);
        req = req.setParameter("password", password);
        try {
            return (Personne) req.getSingleResult();
        } catch (javax.persistence.NoResultException e){
            return null;
        }
    }
}
