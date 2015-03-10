/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity.stateless;

import com.caco.Entity.Personne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andreiy
 */
@Local
public interface PersonneFacadeLocal {

    void createFromNom(String nom);
    
    void createFromParam(String email, String prenom, String nom, String password, int age, String adresse);
  
    void create(Personne personne);

    void edit(Personne personne);

    void remove(Personne personne);

    Personne find(Object id);

    List<Personne> findAll();

    List<Personne> findRange(int[] range);

    int count();
    
}
