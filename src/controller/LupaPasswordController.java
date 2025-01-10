package controller;

import model.Kurir;
import model.KurirMapper;
import model.OTPMapper;
import org.apache.ibatis.session.SqlSession;
import view.HalOTP;
import view.LupaPassword;

import javax.swing.*;
import java.time.LocalDateTime;

public class LupaPasswordController {
    private LupaPassword view;
    private KurirMapper kurirMapper;
    private OTPMapper otpMapper;
    private SqlSession session;
    private OTPController otpController;

    public LupaPasswordController(LupaPassword view, KurirMapper kurirMapper, OTPMapper otpMapper, SqlSession session) {
        this.view = view;
        this.kurirMapper = kurirMapper;
        this.otpMapper = otpMapper;
        this.session = session;

        otpController = new OTPController(otpMapper, session);

        // Listener untuk tombol Kirim
        view.addKirimListener(e -> handleSendOtp(view.getEmailInput()));
    }

    private void handleSendOtp(String email) {
        try {
            // Periksa apakah email terdaftar
            Kurir user = kurirMapper.findKurirByEmail(email);
            if (user == null) {
                JOptionPane.showMessageDialog(view, "Email tidak ditemukan!");
                return;
            }

            // Generate dan simpan OTP
            String kodeOtp = otpController.generateOtp();
            otpController.saveOtp(kodeOtp, LocalDateTime.now().plusMinutes(5), "BELUM_DIPAKAI");

            JOptionPane.showMessageDialog(view, "Kode OTP Anda: " + kodeOtp);

            // Arahkan ke HalOTP untuk validasi
            HalOTP halOtp = new HalOTP();
            halOtp.setOtpController(otpController);
            halOtp.setOperationMode("resetPassword");
            halOtp.setKurirData(kurirMapper, otpMapper, session, null, email, null, null, null);
            halOtp.setVisible(true);
            view.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat mengirim OTP: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
