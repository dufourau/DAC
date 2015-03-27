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
    SPORT,
    CONCERT,
    SPECTACLE,
    DIVERS;  
    
    public static Categorie fromString(String categorie){
        if(categorie.equals("SPORT")){
            return SPORT;
        }
        else if(categorie.equals("CONCERT")){
            return CONCERT;
        }
        else if(categorie.equals("SPECTACLE")){
            return SPECTACLE;
        }
        else if(categorie.equals("DIVERS")){
            return DIVERS;
        }
        else{
            return null;
        }
    }
}
