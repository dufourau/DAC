/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Evenement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andreiy
 */
@Local
public interface EvennementFacadeLocal {

    void create(Evenement evennement);

    void edit(Evenement evennement);

    void remove(Evenement evennement);

    Evenement find(Object id);

    List<Evenement> findAll();

    List<Evenement> findRange(int[] range);

    int count();
    
}
