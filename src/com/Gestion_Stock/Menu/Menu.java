package com.Gestion_Stock.Menu;

import java.util.Scanner;
import com.Gestion_Stock.DAO.CategorieDAO;
import com.Gestion_Stock.DAO.FourniseurDAO;
import com.Gestion_Stock.DAO.MouvementDAO;
import com.Gestion_Stock.DAO.ProduitDAO;
import com.Gestion_Stock.DAO.StockDAO;

public class Menu {
    private final Scanner input = new Scanner(System.in);

    public void lancerMenu() {
        int choix;
        do {
            System.out.println("\n========== GESTION DE STOCK ==========");
            System.out.println("1. Gestion des Categories");
            System.out.println("2. Gestion des Fournisseurs");
            System.out.println("3. Gestion des Produits");
            System.out.println("4. Gestion des Mouvements de Stock");
            System.out.println("5. Etat du stock (ruptures, alertes, valeur)");
            System.out.println("0. Quitter");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> menuCategories();
                case 2 -> menuFournisseurs();
                case 3 -> menuProduits();
                case 4 -> menuMouvements();
                case 5 -> menuStock();
                case 0 -> System.out.println("Merci d'avoir utilise notre application !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void menuCategories() {
        int choix;
        do {
            System.out.println("\n----- GESTION DES CATEGORIES -----");
            System.out.println("1. Ajouter  2. Modifier  3. Supprimer  4. Afficher  0. Retour");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> resultat(CategorieDAO.addcategorie(lireTexte("Nom : ")));
                case 2 -> resultat(CategorieDAO.updatecategorie(lireInt("ID : "), lireTexte("Nouveau nom : ")));
                case 3 -> resultat(CategorieDAO.deletecategorie(lireInt("ID : ")));
                case 4 -> CategorieDAO.showallcategorie();
                case 0 -> { }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void menuFournisseurs() {
        int choix;
        do {
            System.out.println("\n----- GESTION DES FOURNISSEURS -----");
            System.out.println("1. Ajouter  2. Modifier  3. Supprimer  4. Afficher  0. Retour");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> resultat(FourniseurDAO.addfournisseur(lireTexte("Nom : "), lireTexte("Telephone : "), lireTexte("Email : ")));
                case 2 -> {
                    int id = lireInt("ID : ");
                    resultat(FourniseurDAO.updatefournisseur(id, lireTexte("Nom : "), lireTexte("Telephone : "), lireTexte("Email : ")));
                }
                case 3 -> resultat(FourniseurDAO.deletefourniseur(lireInt("ID : ")));
                case 4 -> FourniseurDAO.showallfourniseur();
                case 0 -> { }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void menuProduits() {
        int choix;
        do {
            System.out.println("\n----- GESTION DES PRODUITS -----");
            System.out.println("1. Ajouter  2. Modifier  3. Supprimer  4. Afficher  0. Retour");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> resultat(ProduitDAO.addproduit(lireTexte("Nom : "), lireDouble("Prix : "), lireInt("Quantite : "), lireInt("Seuil d'alerte : "), lireInt("ID categorie : "), lireInt("ID fournisseur : ")));
                case 2 -> {
                    int id = lireInt("ID produit : ");
                    resultat(ProduitDAO.updateproduit(id, lireTexte("Nom : "), lireDouble("Prix : "), lireInt("Quantite : "), lireInt("Seuil d'alerte : "), lireInt("ID categorie : "), lireInt("ID fournisseur : ")));
                }
                case 3 -> resultat(ProduitDAO.deleteproduit(lireInt("ID produit : ")));
                case 4 -> ProduitDAO.showallproduit();
                case 0 -> { }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void menuMouvements() {
        int choix;
        do {
            System.out.println("\n----- MOUVEMENTS DE STOCK -----");
            System.out.println("1. Entree  2. Sortie  3. Afficher les mouvements  0. Retour");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> MouvementDAO.entreeStock(lireInt("ID produit : "), lireInt("Quantite : "));
                case 2 -> MouvementDAO.sortieStock(lireInt("ID produit : "), lireInt("Quantite : "));
                case 3 -> MouvementDAO.showallMouvement();
                case 0 -> { }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void menuStock() {
        int choix;
        do {
            System.out.println("\n----- ETAT DU STOCK -----");
            System.out.println("1. Produits en rupture  2. Produits en alerte  3. Quantite d'un produit  4. Valeur totale  0. Retour");
            choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> StockDAO.showProduitsEnRupture();
                case 2 -> StockDAO.showProduitsEnAlerte();
                case 3 -> StockDAO.showQuantiteStock(lireInt("ID produit : "));
                case 4 -> StockDAO.calculerValeurStock();
                case 0 -> { }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private void resultat(boolean ok) {
        System.out.println(ok ? "Operation effectuee avec succes !" : "Operation echouee. Verifiez les donnees et la base.");
    }
    private String lireTexte(String message) {
        System.out.print(message);
        return input.nextLine().trim();
    }
    private int lireInt(String message) {
        while (true) {
            System.out.print(message);
            try { return Integer.parseInt(input.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Veuillez saisir un entier valide."); }
        }
    }
    private double lireDouble(String message) {
        while (true) {
            System.out.print(message);
            try { return Double.parseDouble(input.nextLine().trim().replace(',', '.')); }
            catch (NumberFormatException e) { System.out.println("Veuillez saisir un nombre valide."); }
        }
    }
}