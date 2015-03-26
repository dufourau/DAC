/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Evenement;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author andreiy
 */
@Local
public interface EvenementFacadeLocal {

    void create(Evenement evennement);

    void edit(Evenement evennement);

    void remove(Evenement evennement);

    Evenement find(Object id);

    List<Evenement> findAll();

    List<Evenement> findRange(int[] range);
    
    List<Evenement> findEvents(String nom, String date, String ville, double prixmin, double prixMax);

    int count();

    void createFromMap(Map<String, Object> evenement);
    
    void createFromParam(String Nom, String Date, String Ville, double Prix);
        
    void removeAll();
}
