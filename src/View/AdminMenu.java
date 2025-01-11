package view;

import java.awt.event.ActionListener;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;


public class AdminMenu extends javax.swing.JFrame {

    private KurirMapper mapper;
    private SqlSession session;

    public AdminMenu(KurirMapper mapper, SqlSession session) {
        this.mapper = mapper;
        this.session = session;
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userBtn = new javax.swing.JButton();
        otpBtn = new javax.swing.JButton();
        riwayatLoginBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Selamat Datang");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Admin");

        userBtn.setBackground(new java.awt.Color(11, 87, 36));
        userBtn.setForeground(new java.awt.Color(255, 255, 255));
        userBtn.setText("Daftar user");
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });

        otpBtn.setBackground(new java.awt.Color(11, 87, 36));
        otpBtn.setForeground(new java.awt.Color(255, 255, 255));
        otpBtn.setText("Daftar OTP");
        otpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpBtnActionPerformed(evt);
            }
        });

        riwayatLoginBtn.setBackground(new java.awt.Color(11, 87, 36));
        riwayatLoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        riwayatLoginBtn.setText("Riwayat Login User");
        riwayatLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riwayatLoginBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(11, 87, 36));
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(riwayatLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(otpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(63, 63, 63)
                .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(otpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(riwayatLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void otpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otpBtnActionPerformed

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtnActionPerformed

    private void riwayatLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riwayatLoginBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_riwayatLoginBtnActionPerformed

    public void addUserButtonListener(ActionListener listener) {
        userBtn.addActionListener(listener);
    }

    public void addOtpButtonListener(ActionListener listener) {
        otpBtn.addActionListener(listener);
    }

    public void addRiwayatLoginButtonListener(ActionListener listener) {
        riwayatLoginBtn.addActionListener(listener);
    }

    public void addLogoutButtonListener(ActionListener listener) {
        logoutBtn.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton otpBtn;
    private javax.swing.JButton riwayatLoginBtn;
    private javax.swing.JButton userBtn;
    // End of variables declaration//GEN-END:variables
}
