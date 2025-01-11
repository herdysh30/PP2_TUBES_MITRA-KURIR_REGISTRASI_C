package controller;

import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.AdminMenu;
import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.OTPMapper;
import model.RiwayatLoginMapper;
import view.OTPListView;
import view.RiwayatLoginView;
import view.UserListView;

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
           UserListView userListView = new UserListView();
            KurirMapper kurirMapper = session.getMapper(KurirMapper.class);
            new UserListController(userListView, kurirMapper, session); 
            userListView.setVisible(true);
        }
    }

    class OtpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            OTPListView otpListView = new OTPListView();
            OTPMapper otpMapper = session.getMapper(OTPMapper.class);
            new OTPListController(otpListView, otpMapper, session);
            otpListView.setVisible(true);
        }
    }

    class RiwayatLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RiwayatLoginView riwayatLoginView = new RiwayatLoginView();
            RiwayatLoginMapper riwayatLoginMapper = session.getMapper(RiwayatLoginMapper.class);
            new RiwayatLoginController(riwayatLoginView, riwayatLoginMapper, session);
            riwayatLoginView.setVisible(true);
        }
    }

}
