package com.Gestion_Stock.DAO;
import java.sql.*;
public class ProduitDAO {
    private static final String URL="jdbc:mysql://localhost:3306/gestion_stock";
    public static boolean addproduit(String nom_produit,double prix,int quantite,int seuil_alerte,int id_categorie,int id_fournisseur) {
        String sql="INSERT INTO produit (nom_produit,prix,quantite,seuil_alerte,id_categorie,id_fournisseur) VALUES (?,?,?,?,?,?)";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom_produit); ps.setDouble(2,prix); ps.setInt(3,quantite); ps.setInt(4,seuil_alerte); ps.setInt(5,id_categorie); ps.setInt(6,id_fournisseur); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static void showallproduit() {
        String sql="SELECT * FROM produit";
        try(Connection con=DriverManager.getConnection(URL,"root",""); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)) {
            while(rs.next()) System.out.println("ID Produit: "+rs.getInt(1)+", Nom Produit: "+rs.getString(2)+", Prix: "+rs.getDouble(3)+", Quantite: "+rs.getInt(4)+", Seuil Alerte: "+rs.getInt(5)+", ID Categorie: "+rs.getInt(6)+", ID Fournisseur: "+rs.getInt(7));
        } catch(Exception e) { System.out.println(e); }
    }
    public static boolean deleteproduit(int id_produit) {
        String sql="DELETE FROM produit WHERE id_produit=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id_produit); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static boolean updateproduit(int id_produit,String nom_produit,double prix,int quantite,int seuil_alerte,int id_categorie,int id_fournisseur) {
        String sql="UPDATE produit SET nom_produit=?,prix=?,quantite=?,seuil_alerte=?,id_categorie=?,id_fournisseur=? WHERE id_produit=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom_produit); ps.setDouble(2,prix); ps.setInt(3,quantite); ps.setInt(4,seuil_alerte); ps.setInt(5,id_categorie); ps.setInt(6,id_fournisseur); ps.setInt(7,id_produit); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
}