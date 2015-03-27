/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @OneToMany
    private List<Evenement> evenenements = new ArrayList<>();;
    private double valeur;

    public Panier() {
        this.valeur = 0;
        this.evenenements = new ArrayList<Evenement>();
    }

    public Panier(Long id, List<Evenement> evenenements, double valeur) {
        this.id = id;
        this.evenenements = evenenements;
        this.valeur = valeur;
    }

    public void addEvenement(Evenement e){
        this.valeur += e.getPrix();
        this.evenenements.add(e);
    }
    
    public List<Evenement> getEvenements() {
        return evenenements;
    }

    public double getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", evenenements=" + evenenements + ", valeur=" + valeur + '}';
    }
    
}
