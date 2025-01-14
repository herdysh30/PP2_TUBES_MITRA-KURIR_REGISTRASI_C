package view;

import controller.LoginController;
import controller.OTPController;
import controller.SessionManager;
import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import model.OTP;
import model.OTPMapper;
import org.apache.ibatis.session.SqlSession;
import java.time.LocalDateTime;;

public class HalOTP extends javax.swing.JDialog {
    private String name;
    private String email;
    private String password;
    private String noTelp;
    private String address;
    private KurirMapper mapper;
    private OTPMapper otpMapper;
    private SqlSession session;
    private String operationMode;
    private OTPController otpController;

    public void setOtpController(OTPController otpController) {
        this.otpController = otpController;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }
    public HalOTP() {
        initComponents();
        
    }
    public void setKurirData(KurirMapper mapper, OTPMapper otpMapper, SqlSession session, 
                             String name, String email, String password, String noTelp, String address) {
        this.session = session;
        this.mapper = mapper;
        this.otpMapper = otpMapper; 
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
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldOTP = new javax.swing.JTextField();
        resendOTPBtn = new javax.swing.JButton();

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

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Untuk memastikan akun ini milik anda,");

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("mohon masukan 6 digit kode keamanan");

        fieldOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldOTPActionPerformed(evt);
            }
        });

        resendOTPBtn.setText("Kirim Ulang OTP");
        resendOTPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendOTPBtnActionPerformed(evt);
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
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(fieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resendOTPBtn))))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(fieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(resendOTPBtn)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifikasiActionPerformed
        String otpInput = getOTPInput();

    if (otpInput == null) {
        // Input tidak valid, keluar dari metode
        return;
    }

    if (otpController.validateOtp(otpInput)) {
        if ("register".equals(operationMode)) {
            handleRegistration();
        } else if ("resetPassword".equals(operationMode)) {
            handleResetPassword();
        }
    }
    }//GEN-LAST:event_btnVerifikasiActionPerformed

    private void fieldOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldOTPActionPerformed

    private void resendOTPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendOTPBtnActionPerformed

        if (mapper == null || session == null || email == null) {
            JOptionPane.showMessageDialog(this, "Data tidak lengkap untuk mengirim ulang OTP.");
            return;
        }

        try {
            // Generate OTP baru
            String kodeOtp = otpController.generateOtp();

            // Simpan OTP ke database
            otpController.saveOtp(kodeOtp, LocalDateTime.now().plusMinutes(5), "BELUM_DIPAKAI");

            // Tampilkan OTP di popup (untuk simulasi)
            JOptionPane.showMessageDialog(this, "Kode OTP baru telah dikirim: " + kodeOtp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengirim ulang OTP: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_resendOTPBtnActionPerformed
    
    private void handleRegistration() {
        try {
            Kurir kurir = new Kurir();
            kurir.setName(name);
            kurir.setEmail(email);
            kurir.setNoTelp(noTelp);
            kurir.setAddress(address);
            kurir.setPassword(password);

            // Simpan data ke database
            mapper.insertKurir(kurir);
            session.commit();

            JOptionPane.showMessageDialog(this, "Registrasi Berhasil! Silahkan Login");
            this.setVisible(false);

            // Arahkan ke halaman login
            Login loginView = new Login();
            new LoginController(loginView, mapper, session);
            loginView.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat registrasi: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void handleResetPassword() {
    try {
        // Dapatkan data pengguna dari email
        Kurir user = mapper.findKurirByEmail(email);
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Pengguna tidak ditemukan!");
            return;
        }

        // Simpan pengguna ke session
        SessionManager.setCurrentUser(user);

        // Arahkan ke halaman ResetPassword
        ResetPassword resetPasswordView = new ResetPassword(mapper, session);
        resetPasswordView.setVisible(true);
        this.dispose(); // Tutup HalOTP
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memproses data: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    public String getOTPInput() {
        String otpInput = fieldOTP.getText().trim();

        // Validasi OTP: harus berisi angka dan panjang 6 digit
        if (otpInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kode OTP tidak boleh kosong!");
            return null;
        }

        if (!otpInput.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(this, "Kode OTP harus terdiri dari 6 digit angka!");
            return null;
        }

        return otpInput;
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerifikasi;
    private javax.swing.JTextField fieldOTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton resendOTPBtn;
    // End of variables declaration//GEN-END:variables
}
