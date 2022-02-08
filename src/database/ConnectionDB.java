/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connection to database
 * @author Adam
 * @version 0.1.0
 */
public class ConnectionDB {
    
    // Host data to connect
    final private String host = "jdbc:derby://localhost:1527/lab-journal";
    final private String uName = "root";
    final private String uPass = "root";
    
    private Connection con; // Connection to DB
    private Statement stmt; // Statement for using query etc
    private ResultSet rs; // ResultSet for getting info etc
    
    public ConnectionDB(){
        try {
            //Connect to DB
            con = DriverManager.getConnection(host, uName, uPass);
            //Create and SetUp Statement to READ data from DB and go to different position
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    //Execute users query
    public void SelectQuery(String query){
        try {
            rs = stmt.executeQuery(query);
            //Get First element in ResultSet
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ExecStatement(String query){
        try {
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet getResultSet(){ 
        return rs;
    }
    
    // Set first element in Result Set
    public void setResultSetToFirstElement(){
        try {
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Set last element in Result Set
    public void setResultSetToLastElement(){
        try {
            rs.last();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Set next element in Result Set
    public void setResultSetToNextElement(){
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setResultSetPreviousElement(){
        try {
            // Set previous element in Result Set
            rs.previous();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
