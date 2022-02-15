/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import database.ConnectionDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Konovalov
 */
public class ShowJournal extends javax.swing.JFrame {

    ConnectionDB connectionDB;
    
    /**
     * Creates new form ShowJournal
     */
    public ShowJournal() {
        initComponents();
        connectionDB = new ConnectionDB();
        AddRecord.setVisible(false);
        DeleteRecord.setVisible(false);
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
        JournalTable = new javax.swing.JTable();
        NextRecord = new javax.swing.JButton();
        PreviousRecord = new javax.swing.JButton();
        FirstRecord = new javax.swing.JButton();
        LastRecord = new javax.swing.JButton();
        AddRecord = new javax.swing.JButton();
        DeleteRecord = new javax.swing.JButton();
        BackToMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Journal(Admin)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JournalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Item_Number", "Description", "Date_Add", "Date_Last_Update"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JournalTable);

        NextRecord.setText("Наступний запис");
        NextRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextRecordActionPerformed(evt);
            }
        });

        PreviousRecord.setText("Попередній запис");
        PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousRecordActionPerformed(evt);
            }
        });

        FirstRecord.setText("Перший запис");
        FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstRecordActionPerformed(evt);
            }
        });

        LastRecord.setText("Останній запис");
        LastRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastRecordActionPerformed(evt);
            }
        });

        AddRecord.setText("Добавити запис");
        AddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordActionPerformed(evt);
            }
        });

        DeleteRecord.setText("Видалити запис");
        DeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRecordActionPerformed(evt);
            }
        });

        BackToMenu.setText("Назад в меню");
        BackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackToMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FirstRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LastRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NextRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PreviousRecord))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddRecord)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DeleteRecord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirstRecord)
                            .addComponent(AddRecord))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastRecord)
                            .addComponent(DeleteRecord)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NextRecord)
                        .addGap(31, 31, 31)
                        .addComponent(PreviousRecord)))
                .addGap(43, 43, 43)
                .addComponent(BackToMenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PreviousRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousRecordActionPerformed
        try {
            if (ConnectionDB.getResultSet().previous()) {

                int Id = ConnectionDB.getResultSet().getInt("Id");
                System.out.print(Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PreviousRecordActionPerformed

    private void NextRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextRecordActionPerformed
        try {
            if (ConnectionDB.getResultSet().next()) {

                int Id = ConnectionDB.getResultSet().getInt("Id");
                System.out.print(Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NextRecordActionPerformed

    private void FirstRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstRecordActionPerformed
        try {
            if (ConnectionDB.getResultSet().first()) {

                int Id = ConnectionDB.getResultSet().getInt("Id");
                System.out.print(Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FirstRecordActionPerformed

    private void AddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordActionPerformed

    }//GEN-LAST:event_AddRecordActionPerformed

    private void DeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRecordActionPerformed

    }//GEN-LAST:event_DeleteRecordActionPerformed

    private void BackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMenuActionPerformed
        new MenuFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackToMenuActionPerformed

    private void LastRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastRecordActionPerformed
        // TODO add your handling code here:
        try {
            if (ConnectionDB.getResultSet().last()) {

                int Id = ConnectionDB.getResultSet().getInt("Id");
                System.out.print(Id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LastRecordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (LoginFrame.getIsAdmin()) {
            AddRecord.setVisible(true);
            DeleteRecord.setVisible(true);
        } else {
            AddRecord.setVisible(false);
            DeleteRecord.setVisible(false);
        }
        
        String showItemsQuery = "SELECT ROOT.\"Journal\".\"Id\", ROOT.\"Journal\".\"Item_Number\", ROOT.\"Journal\".\"Description\", ROOT.\"Journal\".\"Date_Add\", ROOT.\"Journal\".\"Date_Last_Update\" FROM ROOT.\"Journal\"";
        connectionDB.SelectQuery(showItemsQuery);
        JournalTable.setModel(DbUtils.resultSetToTableModel(connectionDB.getResultSet()));
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ShowJournal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowJournal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowJournal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowJournal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowJournal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRecord;
    private javax.swing.JButton BackToMenu;
    private javax.swing.JButton DeleteRecord;
    private javax.swing.JButton FirstRecord;
    private javax.swing.JTable JournalTable;
    private javax.swing.JButton LastRecord;
    private javax.swing.JButton NextRecord;
    private javax.swing.JButton PreviousRecord;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
