/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caco.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
    private String nom;
    private String date;
    private String ville;
    private double prix;

    public Evenement() {
    }

    public Evenement(String nom, String date, String ville, double prix) {
        this.nom = nom;
        this.date = date;
        this.ville = ville;
        this.prix = prix;
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

    public String getDate() {
        return date;
    }

    public String getVille() {
        return ville;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public void setVille(String Ville) {
        this.ville = Ville;
    }

    public void setPrix(double Prix) {
        this.prix = Prix;
    }
    
    
}
