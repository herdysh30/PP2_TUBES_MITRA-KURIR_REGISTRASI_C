package controller;

import view.Login;
import model.Kurir;
import model.KurirMapper;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import org.apache.ibatis.session.SqlSession;
import controller.SessionManager;
import view.AdminMenu;
import view.Menu;

public class LoginController {
    private Login view;
    private KurirMapper mapper;
    private SqlSession session;

    public LoginController(Login view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        view.buttonLoginListener(new ButtonLoginListener());
    }

    // Fungsi untuk hashing password menggunakan SHA-256
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

    class ButtonLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmailInput();
            String password = view.getPasswordInput();

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Email dan password harus diisi!");
                return;
            }

            if (!email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(view, "Format email tidak valid!");
                return;
            }

            try {
                Kurir user = mapper.findKurirByEmail(email);
                if (user != null) {
                    String hashedPassword = hashPassword(password);
                    if (user.getPassword().equals(hashedPassword)) {
                        JOptionPane.showMessageDialog(view, "Login berhasil! Selamat datang, " + user.getName());
                        view.setVisible(false);

                        SessionManager.setCurrentUser(user);

                        // Validasi role
                        if ("admin".equalsIgnoreCase(user.getRole())) {
                            // Admin Menu
                            AdminMenu adminMenuView = new AdminMenu(mapper, session);
                            AdminMenuController adminMenuController = new AdminMenuController(adminMenuView, mapper, session);
                            adminMenuView.setVisible(true);
                        } else {
                            // User Menu
                            Menu menuView = new Menu(mapper, session);
                            MenuController menuController = new MenuController(menuView, mapper, session);
                            menuView.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Password salah!");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Email tidak ditemukan!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Terjadi kesalahan: " + ex.getMessage());
            }
        }
    }

}
