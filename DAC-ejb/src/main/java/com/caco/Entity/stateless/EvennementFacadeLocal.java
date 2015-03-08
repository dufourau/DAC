/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Evennement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andreiy
 */
@Local
public interface EvennementFacadeLocal {

    void create(Evennement evennement);

    void edit(Evennement evennement);

    void remove(Evennement evennement);

    Evennement find(Object id);

    List<Evennement> findAll();

    List<Evennement> findRange(int[] range);

    int count();
    
}
