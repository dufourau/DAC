/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

/**
 *
 * @author clementlinares
 */
public enum Categorie {
    SPORT("Sport"),
    CONCERT("Concert"),
    SPECTACLE("Spectacle"),
    DIVERS("Divers");  
    
    private final String name;       

    private Categorie(String s) {
        name = s;
    }

    
    public static Categorie fromString(String categorie){
        if(categorie.equalsIgnoreCase("SPORT")){
            return SPORT;
        }
        else if(categorie.equalsIgnoreCase("CONCERT")){
            return CONCERT;
        }
        else if(categorie.equalsIgnoreCase("SPECTACLE")){
            return SPECTACLE;
        }
        else if(categorie.equalsIgnoreCase("DIVERS")){
            return DIVERS;
        }
        else{
            return null;
        }
    }
    
    @Override
    public String toString(){
        return name;
    }
}
