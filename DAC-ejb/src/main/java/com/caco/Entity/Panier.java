/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pouzaudr
 */
@Entity(name="Panier")
@Table(name="Panier")
public class Panier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    public Panier() {
        this.reservations = new ArrayList<>();
    }

    public Panier(Long id, List<Reservation> reservations, double valeur) {
        this.id = id;
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) throws RuptureDeStockException{
        for (Reservation r : this.reservations){
            if (r.getEvenement().getId().equals(reservation.getEvenement().getId())){
                r.ajouterTicket(reservation.getNumberOfTickets());
                return;
            }
        }
        reservation.setPanier(this);
        reservation.reserverTicket();
        this.reservations.add(reservation);
    }
    
    public void removeReservation(Reservation reservation) throws PasPresenteException{
        reservation.annuler();
        for (Iterator<Reservation> iterator = reservations.iterator(); iterator.hasNext();) {
            Reservation r = iterator.next();
            if (r.getId().equals(reservation.getId())){
                iterator.remove();
                return;
            }
        }
        throw new PasPresenteException(reservation.getEvenement());
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    public double getValeur() {
        double valeur = 0;
        for (Reservation r : this.reservations){
            valeur += r.getPrix();
        }
        return valeur;
    }
    
    public void update(){
        Date now = new Date();
        for (Iterator<Reservation> iterator = reservations.iterator(); iterator.hasNext();) {
            Reservation r = iterator.next();
            if (now.after(r.getExpirationDate())){
                r.annuler();
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", evenenements=" + reservations + ", valeur=" + getValeur() + '}';
    }
    
}
