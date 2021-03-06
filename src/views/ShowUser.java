/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import static views.ShowJournal.connectionDB;

/**
 *
 * @author Konovalov
 */
public class ShowUser extends javax.swing.JFrame {

    int Id = 0;
    public static ConnectionDB connectionDB;        
    /**
     * Creates new form ShowUser
     */
    public ShowUser() {
        initComponents();
        connectionDB = new ConnectionDB();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        NextRecord = new javax.swing.JButton();
        PreviousRecord = new javax.swing.JButton();
        DeleteRecord = new javax.swing.JButton();
        AddRecord = new javax.swing.JButton();
        FirsrRecord = new javax.swing.JButton();
        LastRecord = new javax.swing.JButton();
        BackToMenu = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        UpdateTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Користувачі");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("ShowUsers"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Username", "Password", "IsAdmin", "Last_Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UserTable.setName("UserTable"); // NOI18N
        jScrollPane1.setViewportView(UserTable);

        NextRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/outline_arrow_right_alt_black_24dp.png"))); // NOI18N
        NextRecord.setLabel("Наступний запис");
        NextRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextRecordActionPerformed(evt);
            }
        });

        PreviousRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/outline_keyboard_backspace_black_24dp.png"))); // NOI18N
        PreviousRecord.setText("Попередній запис");
        PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousRecordActionPerformed(evt);
            }
        });

        DeleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/outline_close_black_24dp.png"))); // NOI18N
        DeleteRecord.setText("Видалити запис");
        DeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRecordActionPerformed(evt);
            }
        });

        AddRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/outline_add_black_24dp.png"))); // NOI18N
        AddRecord.setText("Добавити запис");
        AddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordActionPerformed(evt);
            }
        });

        FirsrRecord.setText("Перший запис");
        FirsrRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirsrRecordActionPerformed(evt);
            }
        });

        LastRecord.setText("Останній запис");
        LastRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastRecordActionPerformed(evt);
            }
        });

        BackToMenu.setText("Назад в меню");
        BackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMenuActionPerformed(evt);
            }
        });

        UpdateButton.setText("Перезавантаження таблиці");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        UpdateTable.setText("Перезавантажити таблицю");
        UpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackToMenu)
                        .addGap(29, 29, 29)
                        .addComponent(UpdateTable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PreviousRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NextRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LastRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FirsrRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddRecord)
                    .addComponent(DeleteRecord))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextRecord)
                    .addComponent(FirsrRecord)
                    .addComponent(AddRecord))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousRecord)
                    .addComponent(LastRecord)
                    .addComponent(DeleteRecord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackToMenu)
                    .addComponent(UpdateTable))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NextRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextRecordActionPerformed
        // TODO add your handling code here:
        try {
            if (ConnectionDB.getResultSet().next()) {

                Id+=1;
                UserTable.changeSelection(Id, 0, false, false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NextRecordActionPerformed

    private void PreviousRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousRecordActionPerformed
        // TODO add your handling code here:
        try {
            if (ConnectionDB.getResultSet().previous()) {
                Id-=1;
            UserTable.changeSelection(Id, 0, false, false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PreviousRecordActionPerformed

    private void FirsrRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirsrRecordActionPerformed
        // TODO add your handling code here:
        try {
            if (ConnectionDB.getResultSet().first()) {

                Id = 0;
                UserTable.changeSelection(Id, 0, false, false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FirsrRecordActionPerformed

    private void LastRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastRecordActionPerformed
        // TODO add your handling code here:
        try {
            if (ConnectionDB.getResultSet().last()) {
                                   Id = ConnectionDB.getResultSet().getInt("UserID");
                UserTable.changeSelection(UserTable.getRowCount() - 1, 0, false, false);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LastRecordActionPerformed

    private void DeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRecordActionPerformed
               int response =  JOptionPane.showConfirmDialog(null, "Ви дійсно хочете видалити запис?");
        String deleteSql = "DELETE FROM users WHERE UserID = " + Id;
        if(response == JOptionPane.YES_OPTION){
        ConnectionDB.ExecStatement(deleteSql);
        UpdateTable();
    }//GEN-LAST:event_DeleteRecordActionPerformed
   }
    private void AddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordActionPerformed
                new AddUser().setVisible(true);
                UpdateTable();

    }//GEN-LAST:event_AddRecordActionPerformed

    private void BackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMenuActionPerformed
        // TODO add your handling code here:
        new MenuFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackToMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                String sql = "SELECT * FROM users";
        ConnectionDB.ExecStatement(sql);
        UpdateTable();
    }//GEN-LAST:event_formWindowOpened

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        UpdateTable();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void UpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTableActionPerformed
        UpdateTable();
        
    }//GEN-LAST:event_UpdateTableActionPerformed

        public void UpdateTable() {
        String showItemsQuery = "SELECT UserID, Username, Password, isAdmin, Last_Login FROM users";
        connectionDB.SelectQuery(showItemsQuery);
        UserTable.setModel(DbUtils.resultSetToTableModel(connectionDB.getResultSet()));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRecord;
    private javax.swing.JButton BackToMenu;
    private javax.swing.JButton DeleteRecord;
    private javax.swing.JButton FirsrRecord;
    private javax.swing.JButton LastRecord;
    private javax.swing.JButton NextRecord;
    private javax.swing.JButton PreviousRecord;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton UpdateTable;
    public static javax.swing.JTable UserTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private TableModel resultSetToTableModel(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
