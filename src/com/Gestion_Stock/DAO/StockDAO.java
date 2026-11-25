package com.Gestion_Stock.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class StockDAO {
    public static void showProduitsEnAlerte() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT id_produit, nom_produit, quantite, seuil_alerte FROM produit WHERE quantite <= seuil_alerte";
            ResultSet rs = stmt.executeQuery(query);
            int compteur = 0;
            while (rs.next()) {
                compteur++;
                System.out.println("ID Produit: " + rs.getInt("id_produit") + ", Nom Produit: " + rs.getString("nom_produit") + ", Quantite: " + rs.getInt("quantite") + ", Seuil Alerte: " + rs.getInt("seuil_alerte"));
            }
            if (compteur == 0) System.out.println("Aucun produit en alerte !");
        } catch (Exception e) { System.out.println(e); }
    }
    public static void showProduitsEnRupture() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM produit WHERE quantite = 0";
            ResultSet rs = stmt.executeQuery(query);
            int compteur = 0;
            while (rs.next()) {
                compteur++;
                System.out.println("ID Produit: " + rs.getInt("id_produit") + ", Nom Produit: " + rs.getString("nom_produit") + ", Quantite: " + rs.getInt("quantite") + ", Seuil Alerte: " + rs.getInt("seuil_alerte"));
            }
            if (compteur == 0) System.out.println("Aucun produit en rupture de stock !");
        } catch (Exception e) { System.out.println(e); }
    }
    public static void showQuantiteStock(int id_produit) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock", "root", "");
            String query = "SELECT id_produit, nom_produit, quantite, seuil_alerte FROM produit WHERE id_produit = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produit);
            System.out.println("ps" + ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID Produit: " + rs.getInt("id_produit") + ", Nom Produit: " + rs.getString("nom_produit") + ", Quantite: " + rs.getInt("quantite") + ", Seuil Alerte: " + rs.getInt("seuil_alerte"));
            } else System.out.println("Produit introuvable !");
        } catch (Exception e) { System.out.println(e); }
    }
    public static void calculerValeurStock() {
        String sql = "SELECT SUM(prix * quantite) AS valeur_totale FROM produit";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock", "root", "");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double valeurTotale = rs.getDouble("valeur_totale");
                System.out.println("===== VALEUR TOTALE DU STOCK =====");
                System.out.println("Valeur totale : " + valeurTotale + " DH");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}