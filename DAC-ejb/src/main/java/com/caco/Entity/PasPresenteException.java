/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

/**
 *
 * @author dufourau
 */
public class PasPresenteException extends Exception {
    
    Evenement evenement;

    public PasPresenteException(Evenement e) {
        this.evenement = e;
    }

    public Evenement getEvenement() {
        return evenement;
    }
    
}
