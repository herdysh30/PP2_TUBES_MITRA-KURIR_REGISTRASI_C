package view;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserListView extends javax.swing.JFrame {

    // Konstruktor
    public UserListView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar User");

        // Tabel untuk daftar user
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nama", "Email", "Nomor Telepon", "Alamat"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        // Tombol kembali
        backButton.setText("Kembali");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        // Tombol refresh
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        
        deleteBtn = new javax.swing.JButton();
        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        
        exportButton.setText("Export PDF");
        

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(backButton)
                .addComponent(deleteBtn)
                .addComponent(refreshButton)
                .addComponent(exportButton)) // Tambahkan tombol Export PDF ke baris tombol
            .addContainerGap()
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Tombol kembali
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Tombol refresh (logic diimplementasikan di Controller)
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    // Akses ke JTable
    public JTable getUserTable() {
        return userTable;
    }

    // Tambahkan Listener ke Tombol
    public void addBackButtonListener(java.awt.event.ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addRefreshButtonListener(java.awt.event.ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
    
    public void addExportButtonListener(ActionListener listener) {
        exportButton.addActionListener(listener);
    }

    // Variables declaration
    private javax.swing.JButton backButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    private javax.swing.JButton deleteBtn;
    private JButton exportButton;
    // End of variables declaration
}
