package com.Gestion_Stock.DAO;
import java.sql.*;
import com.Gestion_Stock.DataBase.DataBaseConnection;
public class MouvementDAO {
    public static boolean addMouvement(String type_mouvement,int quantite,java.sql.Date date_mouvement,int id_produit) {
        String sql="INSERT INTO mouvement_stock (type_mouvement,quantite,date_mouvement,id_produit) VALUES (?,?,?,?)";
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock","root",""); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,type_mouvement); ps.setInt(2,quantite); ps.setDate(3,date_mouvement); ps.setInt(4,id_produit); return ps.executeUpdate()>0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }
    public static void showallMouvement() {
        String sql="SELECT * FROM mouvement_stock";
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock","root",""); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)) {
            while(rs.next()) System.out.println("ID Mouvement: "+rs.getInt(1)+", Type Mouvement: "+rs.getString(2)+", Quantite: "+rs.getInt(3)+", Date Mouvement: "+rs.getDate(4)+", ID Produit: "+rs.getInt(5));
        } catch(Exception e) { System.out.println(e); }
    }
    public static boolean entreeStock(int id_produit,int quantite) { return effectuerMouvement("ENTREE",id_produit,quantite); }
    public static boolean sortieStock(int id_produit,int quantite) { return effectuerMouvement("SORTIE",id_produit,quantite); }
    private static boolean effectuerMouvement(String type_mouvement,int id_produit,int quantite) {
        if(quantite<=0) { System.out.println("La quantite doit etre positive !"); return false; }
        Connection con=null;
        try {
            con=DataBaseConnection.getConnection();
            if(con==null) throw new SQLException("Connexion MySQL indisponible");
            con.setAutoCommit(false);
            int stockActuel;
            String select="SELECT quantite FROM produit WHERE id_produit=? FOR UPDATE";
            try(PreparedStatement ps=con.prepareStatement(select)) {
                ps.setInt(1,id_produit);
                try(ResultSet rs=ps.executeQuery()) {
                    if(!rs.next()) { con.rollback(); System.out.println("Produit introuvable !"); return false; }
                    stockActuel=rs.getInt("quantite");
                }
            }
            int nouveauStock;
            if(type_mouvement.equals("ENTREE")) nouveauStock=stockActuel+quantite;
            else {
                if(stockActuel<quantite) { con.rollback(); System.out.println("Stock insuffisant !"); return false; }
                nouveauStock=stockActuel-quantite;
            }
            try(PreparedStatement ps=con.prepareStatement("UPDATE produit SET quantite=? WHERE id_produit=?")) {
                ps.setInt(1,nouveauStock); ps.setInt(2,id_produit); ps.executeUpdate();
            }
            try(PreparedStatement ps=con.prepareStatement("INSERT INTO mouvement_stock (type_mouvement,quantite,id_produit) VALUES (?,?,?)")) {
                ps.setString(1,type_mouvement); ps.setInt(2,quantite); ps.setInt(3,id_produit); ps.executeUpdate();
            }
            con.commit();
            System.out.println("Mouvement enregistre avec succes !");
            System.out.println("Nouveau stock : "+nouveauStock);
            return true;
        } catch(Exception e) {
            if(con!=null) try { con.rollback(); } catch(Exception ex) { ex.printStackTrace(); }
            e.printStackTrace(); return false;
        } finally {
            if(con!=null) try { con.setAutoCommit(true); con.close(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
}