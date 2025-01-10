package controller;

import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.Login;
import view.Menu;

public class MenuController {
    private Menu view;
    private KurirMapper mapper;
    private SqlSession session;

    public MenuController(Menu view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        // Periksa apakah pengguna sudah login
        if (!SessionManager.isLoggedIn()) {
            JOptionPane.showMessageDialog(view, "Anda harus login terlebih dahulu!");
            view.setVisible(false);

            // Kembali ke halaman login
            Login loginView = new Login();
            LoginController loginController = new LoginController(loginView, mapper, session);
            loginView.setVisible(true);
            return; 
        }

        // Tampilkan email pengguna di menu
        Kurir currentUser = SessionManager.getCurrentUser();
        view.setEmailMessage(currentUser.getEmail());
        view.setNamaUser(currentUser.getName());

        LogoutController logoutController = new LogoutController(mapper, session, view);
        view.addLogoutListener(e -> logoutController.logout());
    }

}
