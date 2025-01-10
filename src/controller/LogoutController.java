package controller;

import view.Login;
import view.Menu;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import javax.swing.JOptionPane;

public class LogoutController {
    private KurirMapper mapper;
    private SqlSession session;
    private Menu menuView; // Referensi ke Menu

    // Constructor untuk menerima mapper, session, dan Menu
    public LogoutController(KurirMapper mapper, SqlSession session, Menu menuView) {
        this.mapper = mapper;
        this.session = session;
        this.menuView = menuView;
    }

    public void logout() {
        // Konfirmasi logout
        int confirm = JOptionPane.showConfirmDialog(null, "Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Hapus sesi
            SessionManager.clearSession();

            // Tutup halaman Menu
            menuView.dispose();

            // Buka halaman Login
            Login loginView = new Login();
            LoginController loginController = new LoginController(loginView, mapper, session);
            loginView.setVisible(true);

            JOptionPane.showMessageDialog(loginView, "Anda telah logout.");
        }
    }
}
