package view;

import controller.LoginController;
import controller.SessionManager;
import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;

public class ResetPassword extends javax.swing.JDialog {
    private KurirMapper mapper;
    private SqlSession session;
    
    public ResetPassword(KurirMapper mapper, SqlSession session) {
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
        btnUbah = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        konpasswordInput = new javax.swing.JPasswordField();
        pwToggle2 = new javax.swing.JButton();
        pwToggle1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Reset Password");

        btnUbah.setBackground(new java.awt.Color(0, 102, 51));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah Password");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jLabel5.setText("Konfirmasi Password Baru");

        jLabel7.setText("Password Baru");

        pwToggle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pwToggle.png"))); // NOI18N
        pwToggle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwToggle2ActionPerformed(evt);
            }
        });

        pwToggle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pwToggle.png"))); // NOI18N
        pwToggle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwToggle1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(konpasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwToggle2)
                            .addComponent(pwToggle1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnUbah)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwToggle1))
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(konpasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwToggle2))
                .addGap(58, 58, 58)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            // Ambil input password
            String password = getPasswordInput();
            String konPassword = getKonPasswordInput();

            // Validasi input
            if (password.isEmpty() || konPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            if (!password.equals(konPassword)) {
                JOptionPane.showMessageDialog(this, "Password dan konfirmasi password tidak cocok!");
                return;
            }

            if (!password.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(this, "Password harus mengandung setidaknya 1 angka!");
                return;
            }

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(this, "Password harus minimal 8 karakter!");
                return;
            }

            // Ambil data pengguna dari SessionManager
            Kurir currentUser = SessionManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this, "Tidak ada pengguna yang sedang login!");
                return;
            }

            // Hash password baru
            String hashedPassword = hashPassword(password);

            // Perbarui password di database
            currentUser.setPassword(hashedPassword);
            mapper.updateKurir(currentUser);
            session.commit();

            JOptionPane.showMessageDialog(this, "Password berhasil diperbarui!");

            // Reset session
            SessionManager.clearSession();

            // Arahkan ke halaman Login
            Login loginView = new Login();
            new LoginController(loginView, mapper, session);
            loginView.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void pwToggle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwToggle1ActionPerformed
        if (passwordInput.getEchoChar() == '*') {
            passwordInput.setEchoChar((char) 0); 
          
        } else {
            passwordInput.setEchoChar('*'); 
            
        }
    }//GEN-LAST:event_pwToggle1ActionPerformed

    private void pwToggle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwToggle2ActionPerformed
        
        if (konpasswordInput.getEchoChar() == '*') {
            konpasswordInput.setEchoChar((char) 0); 
        } else {
            konpasswordInput.setEchoChar('*'); 
        }
    }//GEN-LAST:event_pwToggle2ActionPerformed

    public String getPasswordInput(){
        return passwordInput.getText();
    }
    public String getKonPasswordInput(){
        return konpasswordInput.getText();
    }
    
    private String hashPassword(String password) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField konpasswordInput;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton pwToggle1;
    private javax.swing.JButton pwToggle2;
    // End of variables declaration//GEN-END:variables
}
