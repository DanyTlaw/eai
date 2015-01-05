/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eai_bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dany
 */
public class VctData {
    
    // Database Connection Definitions
    String dbhost = "jdbc:mysql://localhost:3306/eai";
    String dbuser = "root";
    String dbpw = "root";
    Connection con = null;

    // SQL Definitions
    Statement st = null;
    String sql = null;
    ResultSet rs = null;
     
    
    public VctData(){
        
        try {
            
            // Connect to the DB
            con = DriverManager.getConnection(dbhost, dbuser, dbpw);
            
            // Prepare Statement and execute it
            st = con.createStatement( );
            sql = "SELECT * FROM Account";
            rs = st.executeQuery(sql);
            
            // Close DB connection
            // con.close();
            
            
        } catch (Exception e) {
            System.out.println("Problems with the DB.");
        }     
    }
    
    public void closeCon(){
        
        // Close DB connection
        try{
            con.close();
        } catch(Exception e){
            System.out.println("Fehler beim Schliessen der DB-Verbindung");
        } 
    }
}
