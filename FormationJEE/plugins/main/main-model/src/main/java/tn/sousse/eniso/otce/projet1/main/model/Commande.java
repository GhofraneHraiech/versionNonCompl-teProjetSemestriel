/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.sousse.eniso.otce.projet1.main.model;

import java.util.Date;
import net.vpc.upa.RelationshipType;
import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.ManyToOne;

/**
 *
 * @author ghofrane
 */
@Entity
public class Commande {
    @Id
    private int id ;
    private Date dateCommande;
    private double price;
    @ManyToOne(relationType = RelationshipType.AGGREGATION)
    private Personne client;
    private User vendeur;

    public Personne getClient() {
        return client;
    }

    public void setClient(Personne client) {
        this.client = client;
    }

    public User getVendeur() {
        return vendeur;
    }

    public void setVendeur(User vendeur) {
        this.vendeur = vendeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
