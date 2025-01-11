/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.MenuController;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;

public class GantiPassword extends javax.swing.JFrame {

    private KurirMapper mapper;
    private SqlSession session;

    public GantiPassword(KurirMapper mapper, SqlSession session) {
        this.mapper = mapper;
        this.session = session;
        initComponents();
        passwordInput.setEchoChar('*'); 
        konpasswordInput.setEchoChar('*');
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ubahBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        pwToggle1 = new javax.swing.JButton();
        pwToggle2 = new javax.swing.JButton();
        passwordInput = new javax.swing.JPasswordField();
        konpasswordInput = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Buat Password Baru");

        jLabel2.setText("Password Baru");

        jLabel3.setText("Konfirmasi Password Baru");

        jLabel4.setText("Kata sandi baru Anda harus berbeda dari ");

        jLabel5.setText("kata sandi yang digunakan sebelumnya ");

        ubahBtn.setBackground(new java.awt.Color(11, 87, 36));
        ubahBtn.setForeground(new java.awt.Color(255, 255, 255));
        ubahBtn.setText("Ubah");
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        pwToggle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pwToggle.png"))); // NOI18N
        pwToggle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwToggle1ActionPerformed(evt);
            }
        });

        pwToggle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pwToggle.png"))); // NOI18N
        pwToggle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwToggle2ActionPerformed(evt);
            }
        });

        konpasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konpasswordInputActionPerformed(evt);
            }
        });

        jLabel7.setText("*Minimal 5 Karakter dan 1 Angka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(konpasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(71, 71, 71)
                                            .addComponent(jLabel2))
                                        .addComponent(jLabel7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ubahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwToggle1)
                            .addComponent(pwToggle2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(backBtn)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwToggle1)
                    .addComponent(passwordInput))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pwToggle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(konpasswordInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(ubahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(backBtn)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Menu menu = new Menu(mapper, session); 
        MenuController menuController = new MenuController(menu, mapper, session); 
        menu.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_backBtnActionPerformed

    private void pwToggle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwToggle1ActionPerformed
        if (passwordInput.getEchoChar() == '*') {
            passwordInput.setEchoChar((char) 0); // Menampilkan teks asli
          
        } else {
            passwordInput.setEchoChar('*'); // Kembali ke sensor
            
        }
    }//GEN-LAST:event_pwToggle1ActionPerformed

    private void pwToggle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwToggle2ActionPerformed
        if (konpasswordInput.getEchoChar() == '*') {
            konpasswordInput.setEchoChar((char) 0); // Menampilkan teks asli
        } else {
            konpasswordInput.setEchoChar('*'); // Kembali ke sensor
        }
    }//GEN-LAST:event_pwToggle2ActionPerformed

    private void konpasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konpasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_konpasswordInputActionPerformed

    public String getPasswordInput(){
        return passwordInput.getText();
    }
    public String getKonPasswordInput(){
        return konpasswordInput.getText();
    }
    
    public void addUbahPasswordListener(java.awt.event.ActionListener listener) {
        ubahBtn.addActionListener(listener);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField konpasswordInput;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton pwToggle1;
    private javax.swing.JButton pwToggle2;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}
