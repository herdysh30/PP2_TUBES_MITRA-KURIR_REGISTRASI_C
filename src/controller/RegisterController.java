package controller;

import view.Register;
import view.HalOTP;
import model.Kurir;
import model.KurirMapper;
import model.OTP;
import model.OTPMapper;
import org.apache.ibatis.session.SqlSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class RegisterController {
    private Register view;
    private KurirMapper mapper;
    private HalOTP viewOTP;
    private SqlSession session;

    public RegisterController(Register view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        view.buttonDaftarListener(new ButtonDaftarListener());
    }

    private boolean validatePassword(String password) {
        if (password == null || password.length() < 5) {
            return false;
        }
        return password.matches(".*\\d.*");
    }

    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private String generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000; // Generate angka 6 digit
        return String.valueOf(otp);
    }

    private void handleOTP(String email) {
        try {
            String kodeOtp = generateOTP();
            OTP otpModel = new OTP();
            otpModel.setKodeOtp(kodeOtp);
            otpModel.setCreatedAt(LocalDateTime.now());
            otpModel.setExpiresAt(LocalDateTime.now().plusMinutes(5));
            otpModel.setStatus("BELUM_DIPAKAI");

            OTPMapper otpMapper = session.getMapper(OTPMapper.class);
            otpMapper.insertOTP(otpModel);
            session.commit();

            JOptionPane.showMessageDialog(view, "Kode OTP Anda: " + kodeOtp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat menyimpan OTP: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    class ButtonDaftarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String noTelp = view.getNoTelpInput();
            String address = view.getAdressInput();
            String email = view.getEmailInput();
            String password = view.getPasswordInput();
            String konpassword = view.getKonPasswordInput();

            if (!password.equals(konpassword)) {
                JOptionPane.showMessageDialog(view, "Password dan konfirmasi password tidak cocok.");
                return;
            }

            if (!validatePassword(password)) {
                JOptionPane.showMessageDialog(view, "Password harus minimal 5 karakter dan mengandung setidaknya 1 angka.");
                return;
            }

            if (!email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(view, "Format email tidak valid!");
                return;
            }

            Kurir existingKurir = mapper.findKurirByEmail(email);
            if (existingKurir != null) {
                JOptionPane.showMessageDialog(view, "Email sudah terdaftar! Gunakan Email Lain");
                return;
            }

            if (name.isEmpty() || email.isEmpty() || noTelp.isEmpty() || address.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Lengkapi Semua Formulirnya!");
                return;
            }

            try {
                String hashedPassword = hashPassword(password);

                // Kirim data OTP
                handleOTP(email);

                // Navigasi ke halaman OTP
                view.setVisible(false);
                OTPMapper otpMapper = session.getMapper(OTPMapper.class); 
                viewOTP = new HalOTP();
                viewOTP.setKurirData(mapper, otpMapper, session, name, email, hashedPassword, noTelp, address);
                viewOTP.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat memproses data: " + ex.getMessage());
            }
        }
    }
}
