/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Categorie;
import com.caco.Entity.Evenement;
import java.util.Date;
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
    
    List<Evenement> findEvents(String nom, Date date, String ville, double prixmin, double prixMax, String categorie);
    
    List<Evenement> findEvents(String nom);

    int count();

    void createFromMap(Map<String, Object> evenement);
    
    void createFromParam(String Nom, Date Date, String Ville, double Prix, Categorie categorie, int quantiteInitiale);
        
    void removeAll();
    
    void remove(String title);
}
