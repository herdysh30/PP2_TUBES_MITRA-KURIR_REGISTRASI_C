package controller;

import view.Login;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import javax.swing.JOptionPane;

public class LogoutController {
    private KurirMapper mapper;
    private SqlSession session;

    // Constructor untuk menerima mapper dan session
    public LogoutController(KurirMapper mapper, SqlSession session) {
        this.mapper = mapper;
        this.session = session;
    }

    public void logout() {
        // Konfirmasi logout
        int confirm = JOptionPane.showConfirmDialog(null, "Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            SessionManager.clearSession();

            // Kembali ke halaman login
            Login loginView = new Login();
            LoginController loginController = new LoginController(loginView, mapper, session);
            loginView.setVisible(true);

            JOptionPane.showMessageDialog(loginView, "Anda telah logout.");
        }
    }
}
