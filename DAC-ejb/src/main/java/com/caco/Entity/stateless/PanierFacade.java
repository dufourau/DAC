/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Panier;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pouzaudr
 */
@Stateless
@EJB(name="ejb/PanierFacade",beanInterface=PanierFacadeLocal.class,beanName="PanierFacade")
public class PanierFacade extends AbstractFacade<Panier> implements PanierFacadeLocal  {
    
    private static final Logger LOGGER = LogManager.getLogger(PanierFacade.class);
    
    @PersistenceContext(unitName = "com.caco_DAC-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierFacade() {
        super(Panier.class);
    }
    
}
