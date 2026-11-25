package com.Gestion_Stock.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock", "root", "");
            System.out.println("Connection is successfuly");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}