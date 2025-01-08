/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;

public class OTP extends javax.swing.JDialog {
    private String name;
    private String email;
    private String password;
    private String noTelp;
    private String address;
    private KurirMapper mapper;
    private SqlSession session;

    public OTP() {
        initComponents();
        
    }
    public void setKurirData(KurirMapper mapper,SqlSession session, String name, String email, String password, String noTelp, String address) {
        this.session = session;
        this.mapper = mapper;
        this.name = name;
        this.email = email;
        this.password = password;
        this.noTelp = noTelp;
        this.address = address;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVerifikasi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fieldOTP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Verifikasi");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Masukan kode Verifikasi");

        btnVerifikasi.setBackground(new java.awt.Color(0, 102, 51));
        btnVerifikasi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerifikasi.setForeground(new java.awt.Color(255, 255, 255));
        btnVerifikasi.setText("Verifikasi");
        btnVerifikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifikasiActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Frame.png"))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Untuk memastikan akun ini milik anda,");

        jLabel9.setForeground(new java.awt.Color(51, 102, 255));
        jLabel9.setText("Kirim ulang");

        jLabel10.setForeground(new java.awt.Color(51, 102, 255));
        jLabel10.setText("Kirim ulang ");

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("mohon masukan 6 digit kode keamanan");

        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText(" kode verifikasi");

        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText(" dengan metode lain");

        fieldOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldOTPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel13))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14)))
                            .addComponent(fieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))))
                .addGap(62, 62, 62)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(fieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifikasiActionPerformed
        String otpInput = getOTPInput();  // Ambil input OTP

        if ("123456".equals(otpInput)) {
            // Jika OTP benar, lanjutkan proses pembuatan kurir
            Kurir kurir = new Kurir();
            kurir.setName(name);
            kurir.setEmail(email);
            kurir.setNoTelp(noTelp);
            kurir.setAddress(address);
            kurir.setPassword(password);

            // Simpan data ke database
            mapper.insertKurir(kurir);
            session.commit();
            JOptionPane.showMessageDialog(this, "Registrasi Berhasil!");
            this.setVisible(false); 
            // Arahkan ke tampilan lain jika perlu
        } else {

            JOptionPane.showMessageDialog(this, "OTP salah, coba lagi!");
        }
    }//GEN-LAST:event_btnVerifikasiActionPerformed

    private void fieldOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldOTPActionPerformed
    public String getOTPInput(){
        return fieldOTP.getText();
    }
    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OTP().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerifikasi;
    private javax.swing.JTextField fieldOTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
