package controller;

import model.OTP;
import model.OTPMapper;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.time.LocalDateTime;

public class OTPController {
    private OTPMapper otpMapper;
    private SqlSession session;

    public OTPController(OTPMapper otpMapper, SqlSession session) {
        this.otpMapper = otpMapper;
        this.session = session;
    }

    // Fungsi untuk membuat OTP baru
    public String generateOtp() {
        int otp = (int) (Math.random() * 900000) + 100000; // 6 digit angka
        return String.valueOf(otp);
    }

    // Fungsi untuk menyimpan OTP ke database
    public void saveOtp(String kodeOtp, LocalDateTime expiresAt, String status) {
        try {
            OTP otp = new OTP();
            otp.setKodeOtp(kodeOtp);
            otp.setCreatedAt(LocalDateTime.now());
            otp.setExpiresAt(expiresAt);
            otp.setStatus(status);

            otpMapper.insertOTP(otp);
            session.commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan OTP: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Fungsi untuk memvalidasi OTP
    public boolean validateOtp(String kodeOtp) {
        try {
            OTP otp = otpMapper.findByKodeOtp(kodeOtp);

            if (otp == null) {
                JOptionPane.showMessageDialog(null, "Kode OTP tidak ditemukan!");
                return false;
            }

            if (otp.getExpiresAt() == null || otp.getExpiresAt().isBefore(LocalDateTime.now())) {
                JOptionPane.showMessageDialog(null, "Kode OTP telah kedaluwarsa!");
                return false;
            }

            if ("DIPAKAI".equals(otp.getStatus())) {
                JOptionPane.showMessageDialog(null, "Kode OTP sudah digunakan!");
                return false;
            }

            // Tandai OTP sebagai digunakan
            otpMapper.updateStatus(otp.getOtpId());
            session.commit();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memvalidasi OTP: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
