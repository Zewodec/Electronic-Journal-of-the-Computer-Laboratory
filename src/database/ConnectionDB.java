/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connection to database
 *
 * @author Adam
 * @version 0.1.0
 */
public class ConnectionDB {

    // Host data to connect
    final private String host = "jdbc:derby://localhost:1527/lab-journal";
    final private String uName = "root";
    final private String uPass = "root";

    private static Connection con; // Connection to DB
    private static Statement stmt; // Statement for using query etc
    private static ResultSet rs; // ResultSet for getting info etc

    public ConnectionDB() {
        try {
            //Connect to DB
            con = DriverManager.getConnection(host, uName, uPass);
            //Create and SetUp Statement to READ data from DB and go to different position
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    //Execute users query
    public void SelectQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            //Get First element in ResultSet
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ExecStatement(String query) {
        try {
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSet getResultSet() {
        return rs;
    }

    // Set first element in Result Set
    public void setResultSetToFirstElement() {
        try {
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set last element in Result Set
    public void setResultSetToLastElement() {
        try {
            rs.last();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set next element in Result Set
    public void setResultSetToNextElement() {
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setResultSetPreviousElement() {
        try {
            // Set previous element in Result Set
            rs.previous();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkUserAuth(String username, String password) {

        try {
            String loginQuery = "SELECT ROOT.\"USERS\".\"USERNAME\", ROOT.\"USERS\".\"PASSWORD\" FROM ROOT.\"USERS\" WHERE ROOT.\"USERS\".\"USERNAME\" = ? AND ROOT.\"USERS\".\"PASSWORD\" = ?";

            PreparedStatement preparedLoginQuery = con.prepareStatement(loginQuery);

            preparedLoginQuery.setString(1, username);
            preparedLoginQuery.setString(2, password);

            rs = preparedLoginQuery.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (rs != null) {
            return true;
        }
        return false;
    }

    public int checkUserAdmin(String username, String password) {
        int value = 0;
        try {
//            String loginQuery = "SELECT ROOT.\"USERS\".\"USERNAME\", ROOT.\"USERS\".\"ISADMIN\" FROM ROOT.\"USERS\" WHERE ROOT.\"USERS\".\"USERNAME\" = ? AND ROOT.\"USERS\".\"PASSWORD\" = ?";
        String loginQuery = "SELECT USERNAME, ISADMIN FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement preparedLoginQuery = con.prepareStatement(loginQuery);

            preparedLoginQuery.setString(1, username);
            preparedLoginQuery.setString(2, password);

            rs = preparedLoginQuery.executeQuery();

            rs.next();

            if (rs.getBoolean("ISADMIN")) {
                value = 1;
            } else {
            value = 0;
            }
            
System.out.println("Value!!!==== " + value);
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            value = 2;
        }
        System.out.println("Value!!!==== " + value);
        return value;
    }

}
