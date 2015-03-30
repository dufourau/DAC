/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pouzaudr
 */

@Entity(name="Reservation")
@Table(name="Reservation")
public class Reservation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Evenement evenement;
    private int numberOfTickets;
    
    public Reservation() {
    }
    
    public Reservation(Evenement evenement, int numberOfTickets){
        this.evenement = evenement;
        this.numberOfTickets = numberOfTickets;
    }
    
    public Evenement getEvenement(){
        return this.evenement;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    
    public double getPrix(){
        return numberOfTickets*this.evenement.getPrix();
    }
    
    public void ajouterTicket(int numberOfTickets) throws RuptureDeStockException{
        this.evenement.reserverTickets(numberOfTickets);
        this.numberOfTickets += numberOfTickets;
    }

    void reserverTicket() throws RuptureDeStockException {
        this.evenement.reserverTickets(this.getNumberOfTickets());
    }
    
    public void retirerTicket(){
        this.numberOfTickets = 0;
        this.evenement.enleverTickets(numberOfTickets);
    }
    
}
