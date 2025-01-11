

package view;

import controller.GantiPasswordController;
import controller.ProfileController;
import controller.SessionManager;
import java.awt.event.ActionListener;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;

public class Menu extends javax.swing.JFrame {
    
    private KurirMapper mapper;
    private SqlSession session;

    public Menu(KurirMapper mapper, SqlSession session) {
        this.mapper = mapper;
        this.session = session;
        initComponents();
        loadUserData();
    }

    public Menu() {
        initComponents();
    }
    
    public void loadUserData() {
    Kurir currentUser = SessionManager.getCurrentUser();
    if (currentUser != null) {
        setNamaUser(currentUser.getName());
        setEmailMessage(currentUser.getEmail());
    } else {
        setNamaUser("Nama User");
        setEmailMessage("Email User");
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLabel = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        gantiPasswordBtn = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        namaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hapusAkun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("email user");

        profileBtn.setBackground(new java.awt.Color(11, 87, 36));
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setText("Profile");
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        gantiPasswordBtn.setBackground(new java.awt.Color(11, 87, 36));
        gantiPasswordBtn.setForeground(new java.awt.Color(255, 255, 255));
        gantiPasswordBtn.setText("Ganti Password");
        gantiPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gantiPasswordBtnActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(11, 87, 36));
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        namaLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        namaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaLabel.setText("Nama User");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Selamat Datang");

        hapusAkun.setBackground(new java.awt.Color(11, 87, 36));
        hapusAkun.setForeground(new java.awt.Color(255, 255, 255));
        hapusAkun.setText("Hapus Akun");
        hapusAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusAkunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(namaLabel)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(gantiPasswordBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapusAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(124, 124, 124))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(gantiPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hapusAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        Profile profile = new Profile(mapper, session); 
        ProfileController profileController = new ProfileController(profile, mapper, session); 
        profile.setVisible(true);
        this.dispose(); 

    }//GEN-LAST:event_profileBtnActionPerformed

    private void gantiPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gantiPasswordBtnActionPerformed
        GantiPassword gantiPasswordView = new GantiPassword(mapper, session);
        GantiPasswordController gantiPasswordController = new GantiPasswordController(gantiPasswordView, mapper, session);
        gantiPasswordView.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_gantiPasswordBtnActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void hapusAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusAkunActionPerformed
        
    }//GEN-LAST:event_hapusAkunActionPerformed


    public void setEmailMessage(String email) {
       emailLabel.setText(email);
    }
    public void setNamaUser(String name) {
       namaLabel.setText(name);
    }

    public void addLogoutListener(ActionListener listener) {
       logoutButton.addActionListener(listener);
    }
    
    public void addHapusAkunListener(ActionListener listener) {
        hapusAkun.addActionListener(listener);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton gantiPasswordBtn;
    private javax.swing.JButton hapusAkun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton profileBtn;
    // End of variables declaration//GEN-END:variables
}
