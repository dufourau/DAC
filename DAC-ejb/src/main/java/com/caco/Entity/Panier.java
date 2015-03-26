/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
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
    private List<Evenement> evenenements;
    private double valeur;

    public Panier() {
    }

    public Panier(Long id, List<Evenement> evenenements, double valeur) {
        this.id = id;
        this.evenenements = evenenements;
        this.valeur = valeur;
    }

    public List<Evenement> getEvenenements() {
        return evenenements;
    }

    public double getValeur() {
        double somme = 0;
        for (Evenement e : evenenements){
            somme += e.getPrix();
        }
        return somme;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", evenenements=" + evenenements + ", valeur=" + valeur + '}';
    }
    
}
