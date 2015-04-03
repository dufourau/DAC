/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    // Expiration time in seconds : 15 minutes
    private static int timeOut = 15*60000;
    
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Evenement evenement;
    @OneToOne
    private Panier panier;
    private int numberOfTickets;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    
    public Reservation() {
    }
    
    public Reservation(Evenement evenement, int numberOfTickets){
        super();
        this.evenement = evenement;
        this.numberOfTickets = numberOfTickets;
        this.expirationDate = new Date( (new Date().getTime()) + timeOut);
        evenement.addReservation(this);
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
    
    public void ajouterTicket(int numberOfTickets) throws RuptureDeStockException{
        this.evenement.reserverTickets(numberOfTickets);
        this.numberOfTickets += numberOfTickets;
    }

    void reserverTicket() throws RuptureDeStockException {
        this.evenement.reserverTickets(this.getNumberOfTickets());
    }
    
    public void annuler(){
        this.evenement.annuler(this);
        this.numberOfTickets = 0;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", evenement=" + evenement.getNom() + ", numberOfTickets=" + numberOfTickets + ", expirationDate=" + expirationDate + '}';
    }    
    
}
