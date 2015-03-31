/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andreiy
 */
@Entity(name="Evenement")
@Table(name="Evenement")
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String nom;
    private String lieu;
    private double prix;
    private int quantiteDisponible;
    
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    public Evenement() {
    }

    public Evenement(String nom, Date date, String lieu, double prix, Categorie categorie, int quantiteInitiale) {
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.prix = prix;
        this.categorie = categorie;
        this.quantiteDisponible = quantiteInitiale;
        this.reservations = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.caco.Entity.Evenement[ id=" + id + " ]";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public double getPrix() {
        return prix;
    }
    
    public Categorie getCategorie(){
        return categorie;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public void setVille(String Ville) {
        this.lieu = Ville;
    }

    public void setPrix(double Prix) {
        this.prix = Prix;
    }
    
    public void setCategorie(Categorie Categorie){
        this.categorie = Categorie;
    }
    
    public int reserverTickets(int numberOfTickets) throws RuptureDeStockException {
        if (this.quantiteDisponible < numberOfTickets) {
            throw new RuptureDeStockException(this, numberOfTickets);
        } else {
            this.quantiteDisponible = this.quantiteDisponible - numberOfTickets;
            return this.quantiteDisponible;
        }
    }
    
    public int annulerTickets(int numberOfTickets) {
        this.quantiteDisponible += numberOfTickets;
        return this.quantiteDisponible;
    }
    
}
