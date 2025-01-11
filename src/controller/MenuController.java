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
        
        view.addHapusAkunListener(e -> handleHapusAkun());

        LogoutController logoutController = new LogoutController(mapper, session, view);
        view.addLogoutListener(e -> logoutController.logout());
    }
    
    public void handleHapusAkun() {
        try {
            // Konfirmasi penghapusan akun
            int confirm = JOptionPane.showConfirmDialog(view, 
                "Apakah Anda yakin ingin menghapus akun Anda? Tindakan ini tidak dapat dibatalkan.", 
                "Konfirmasi Hapus Akun", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Ambil data pengguna dari session
                Kurir currentUser = SessionManager.getCurrentUser();
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(view, "Tidak ada pengguna yang sedang login!");
                    return;
                }

                // Hapus akun dari database
                mapper.deleteKurir(currentUser.getId());
                session.commit();

                // Hapus sesi pengguna
                SessionManager.clearSession();

                // Tampilkan pesan sukses
                JOptionPane.showMessageDialog(view, "Akun Anda berhasil dihapus!");

                // Arahkan ke halaman login
                Login loginView = new Login();
                new LoginController(loginView, mapper, session);
                view.dispose();
                loginView.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat menghapus akun: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
