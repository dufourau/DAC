/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

/**
 *
 * @author pouzaudr
 */
public class RuptureDeStockException extends Exception {
    
    Evenement evenement;
    int quantiteDemandee;

    public RuptureDeStockException(Evenement e, int quantiteDemandee) {
        this.evenement = e;
        this.quantiteDemandee = quantiteDemandee;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public int getQuantiteDemandee() {
        return quantiteDemandee;
    }
    
}
