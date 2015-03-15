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
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author andreiy
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
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
    public void createFromYaml(String yml){
        
        Yaml yaml = new Yaml();
        Personne personne = (Personne) yaml.load(yml);
        create(personne);
        
    }
    
    @Override
    public void createFromObject(Object personne){
        
        Map<String, Object> result= (Map<String, Object>) personne;
        System.out.println(result.toString());
        //create((Personne) personne);
        
    }
    
}
