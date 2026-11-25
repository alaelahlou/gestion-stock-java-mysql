package com.Gestion_Stock.Model;
import java.sql.Date;
public class Mouvement {
    private int id_mouvement;
    private String type_mouvement;
    private int quantite;
    private Date date_mouvement;
    private int id_produit;
    public Mouvement(int id_mouvement, String type_mouvement, int quantite, Date date_mouvement, int id_produit) {
        super();
        this.id_mouvement = id_mouvement;
        this.type_mouvement = type_mouvement;
        this.quantite = quantite;
        this.date_mouvement = date_mouvement;
        this.id_produit = id_produit;
    }
    public int getId_mouvement() { return id_mouvement; }
    public void setId_mouvement(int id_mouvement) { this.id_mouvement = id_mouvement; }
    public String getType_mouvement() { return type_mouvement; }
    public void setType_mouvement(String type_mouvement) { this.type_mouvement = type_mouvement; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public Date getDate_mouvement() { return date_mouvement; }
    public void setDate_mouvement(Date date_mouvement) { this.date_mouvement = date_mouvement; }
    public int getId_produit() { return id_produit; }
    public void setId_produit(int id_produit) { this.id_produit = id_produit; }
    @Override public String toString() {
        return "MouvementStock [id=" + id_mouvement + ", type=" + type_mouvement + ", quantite=" + quantite + ", date=" + date_mouvement + ", produit=" + id_produit + "]";
    }
}