/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;
/**
 *
 * @author Cecile Iaegi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Cécile IAEGI
 * @version 05/03/2018
 */
public class SQLiteJDBCDriverConnection {
    private Connection conn;
     /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:src/resources/ihm_bdd.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return(conn);
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Connection recon = connect();
//        Statement stmt = null;
//        String sql = "select IdEleve,NomEleve from Eleve";
//        try{
//        stmt = recon.createStatement();
//        
//        ResultSet rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            int id = rs.getInt("IdEleve");
//            String nameE = rs.getString("NomEleve");
//            System.out.println(id + "\t" +nameE );
//        }
//        
//                
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        
//        
//    }
}





