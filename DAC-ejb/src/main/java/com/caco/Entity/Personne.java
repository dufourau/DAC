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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dufourau
 */
@Entity(name="Personne")
@Table(name="Personne")
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String prenom;
    private String nom;
    private String password;
    private int age;
    private String adresse;
    private boolean admin;
    @OneToOne(cascade = CascadeType.ALL)
    private Panier panier;

    public Personne(String email, String prenom, String nom, String password, int age, String adresse) {
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.age = age;
        this.adresse = adresse;
        this.panier = new Panier();
        this.admin = false;
    }

    public Personne() {
    }
    
    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
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
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public Reservation ajouterAuPanier(Reservation r) throws RuptureDeStockException{
        this.panier.addReservation(r);
        return r;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public Reservation retirerDuPanier(Reservation r) throws PasPresenteException{
        this.panier.removeReservation(r);
        return r;
    }
      
    @Override
    public String toString() {
        return "com.caco.Entity.Personne[ id=" + id + "\nemail=" + email + " ]";
    }
    
}
