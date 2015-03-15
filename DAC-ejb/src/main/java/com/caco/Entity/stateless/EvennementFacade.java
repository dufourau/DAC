/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Evenement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andreiy
 */
@Stateless
public class EvennementFacade extends AbstractFacade<Evenement> implements EvennementFacadeLocal {
    @PersistenceContext(unitName = "com.caco_DAC-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvennementFacade() {
        super(Evenement.class);
    }
    
}
