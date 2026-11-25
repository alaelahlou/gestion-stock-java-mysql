package com.Gestion_Stock.DAO;
import java.sql.*;
public class FourniseurDAO {
    private static final String URL="jdbc:mysql://localhost:3306/gestion_stock";
    public static boolean addfournisseur(String nom,String telephone,String email) {
        String sql="INSERT INTO fournisseur (nom,telephone,email) VALUES (?,?,?)";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom); ps.setString(2,telephone); ps.setString(3,email); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static void showallfourniseur() {
        String sql="SELECT * FROM fournisseur";
        try(Connection con=DriverManager.getConnection(URL,"root",""); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)) {
            while(rs.next()) System.out.println("ID: "+rs.getInt(1)+" Nom Fournisseur: "+rs.getString(2)+" Num Fournisseur: "+rs.getString(3)+" Mail Fournisseur: "+rs.getString(4));
        } catch(Exception e) { System.out.println(e); }
    }
    public static boolean deletefourniseur(int id_fournisseur) {
        String sql="DELETE FROM fournisseur WHERE id_fournisseur=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id_fournisseur); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static boolean updatefournisseur(int id_fournisseur,String nom,String telephone,String email) {
        String sql="UPDATE fournisseur SET nom=?, telephone=?, email=? WHERE id_fournisseur=?";
        try(Connection con=DriverManager.getConnection(URL,"root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,nom); ps.setString(2,telephone); ps.setString(3,email); ps.setInt(4,id_fournisseur); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
}