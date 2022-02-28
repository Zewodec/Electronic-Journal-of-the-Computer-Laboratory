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
 * @author Konovalov
 * @version 0.2.0
 */
public class ConnectionDB {

    // Host data to connect
    final private String host = "jdbc:mysql://YOUR_IP:3306/YOUR_DB_NAME";
    final private String uName = "YOUR_DB_USERNAME";
    final private String uPass = "YOUR_DB_PASSWORD";

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
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ExecStatement(String query) {
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
    public static void setResultSetToFirstElement() {
        try {
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set last element in Result Set
    public static void setResultSetToLastElement() {
        try {
            rs.last();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set next element in Result Set
    public static void setResultSetToNextElement() {
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setResultSetPreviousElement() {
        try {
            // Set previous element in Result Set
            rs.previous();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkUserAuth(String username, String password) {

        try {
            String loginQuery = "SELECT Username, Password FROM users WHERE Username = ? AND Password = ?";

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
    
    public void AddJournalRecord(int ItemNumber, String Description){
        
        try {
            String addRecordQuery = "INSERT  INTO JOURNAL (ItemNum, Description) VALUES(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(addRecordQuery);
            
            preparedStatement.setInt(1, ItemNumber);
            preparedStatement.setString(2, Description);
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    

    public void AddUserRecord( String username, String password, boolean isAdmin){
        
        try {
            String addRecordQuery = "INSERT  INTO USERS (Username, Password, isAdmin) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(addRecordQuery);
            
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setBoolean(3, isAdmin);
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
    
    public int checkUserAdmin(String username, String password) {
        int value = 0;
        try {
        String loginQuery = "SELECT USERNAME, ISADMIN FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement preparedLoginQuery = con.prepareStatement(loginQuery);

            preparedLoginQuery.setString(1, username);
            preparedLoginQuery.setString(2, password);

            rs = preparedLoginQuery.executeQuery();

            rs.next();

            if (rs.getBoolean("ISADMIN")) {
                value = 1;
                UpdateLoginTimeStamp(username, password);
            } else {
            value = 0;
                UpdateLoginTimeStamp(username, password);
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
    
    private void UpdateLoginTimeStamp(String username, String password){
        try {
            String UpdateLoginTimeStamp = "UPDATE users SET Last_Login = CURRENT_TIMESTAMP  WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement preparedUpdateLoginTimeStampQuery = con.prepareStatement(UpdateLoginTimeStamp);

            preparedUpdateLoginTimeStampQuery.setString(1, username);
            preparedUpdateLoginTimeStampQuery.setString(2, password);

            preparedUpdateLoginTimeStampQuery.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
