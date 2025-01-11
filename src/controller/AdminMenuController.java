package controller;

import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.AdminMenu;
import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuController {
    private AdminMenu view;
    private KurirMapper mapper;
    private SqlSession session;

    public AdminMenuController(AdminMenu view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        // Tambahkan listener untuk setiap tombol
        view.addUserButtonListener(new UserButtonListener());
        view.addOtpButtonListener(new OtpButtonListener());
        view.addRiwayatLoginButtonListener(new RiwayatLoginButtonListener());

        
        LogoutController logoutController = new LogoutController(mapper, session, view);
        view.addLogoutButtonListener(e -> logoutController.logout());
    }

    class UserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "Fitur Daftar User dipilih.");
            // Implementasikan logika untuk membuka daftar user (dengan JTable)
        }
    }

    class OtpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "Fitur Daftar OTP dipilih.");
            // Implementasikan logika untuk membuka daftar OTP (dengan JTable)
        }
    }

    class RiwayatLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "Fitur Riwayat Login User dipilih.");
            // Implementasikan logika untuk melihat riwayat login user
        }
    }

}
