/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labarotoryjournal;

import database.ConnectionDB;
import views.LoginFrame;

/**
 *
 * @author Adam
 */
public class LabarotoryJournal {

    
    final public static ConnectionDB con = new ConnectionDB();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    
}
