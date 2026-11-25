package com.Gestion_Stock.DAO;
import java.sql.*;
public class CategorieDAO {
    private static final String URL="jdbc:mysql://localhost:3306/gestion_stock";
    public static boolean addcategorie(String nom_categorie) {
        String sql="INSERT INTO categorie (nom_categorie) VALUES (?)";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom_categorie); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static void showallcategorie() {
        String sql="SELECT * FROM categorie";
        try(Connection con=DriverManager.getConnection(URL,"root",""); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)) {
            while(rs.next()) System.out.println("ID: "+rs.getInt(1)+", Nom Categorie: "+rs.getString(2));
        } catch(Exception e) { System.out.println(e); }
    }
    public static boolean deletecategorie(int id_categorie) {
        String sql="DELETE FROM categorie WHERE id_categorie=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id_categorie); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static boolean updatecategorie(int id_categorie,String nom_categorie) {
        String sql="UPDATE categorie SET nom_categorie=? WHERE id_categorie=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom_categorie); ps.setInt(2,id_categorie); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
}