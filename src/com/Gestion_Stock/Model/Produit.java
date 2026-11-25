package com.Gestion_Stock.Model;
public class Produit {
    private int id_produit;
    private String nom;
    private double prix;
    private int quantite;
    private int seuil_alerte;
    private int id_categorie;
    private int id_fournisseur;
    public Produit(int id_produit, String nom, double prix, int quantite, int seuil_alerte, int id_categorie, int id_fournisseur) {
        super();
        this.id_produit = id_produit;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.seuil_alerte = seuil_alerte;
        this.id_categorie = id_categorie;
        this.id_fournisseur = id_fournisseur;
    }
    public int getId_produit() { return id_produit; }
    public void setId_produit(int id_produit) { this.id_produit = id_produit; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public int getseuil_alerte() { return seuil_alerte; }
    public void setseuil_alerte(int seuil_alerte) { this.seuil_alerte = seuil_alerte; }
    public int getId_categorie() { return id_categorie; }
    public void setId_categorie(int id_categorie) { this.id_categorie = id_categorie; }
    public int getId_fournisseur() { return id_fournisseur; }
    public void setId_fournisseur(int id_fournisseur) { this.id_fournisseur = id_fournisseur; }
    @Override public String toString() {
        return "Produit [id=" + id_produit + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + ", seuil_alerte=" + seuil_alerte + ", categorie=" + id_categorie + ", fournisseur=" + id_fournisseur + "]";
    }
}