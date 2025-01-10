package controller;

import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.GantiPassword;
import view.Menu;

public class GantiPasswordController {
    private GantiPassword view;
    private KurirMapper mapper;
    private SqlSession session;

    public GantiPasswordController(GantiPassword view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        view.addUbahPasswordListener(e -> ubahPassword());
    }

    private void ubahPassword() {
        try {
            // Ambil password baru dan konfirmasi dari form
            String newPassword = view.getPasswordInput();
            String confirmPassword = view.getKonPasswordInput();

            // Validasi form tidak boleh kosong
            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Semua field harus diisi!");
                return;
            }

            // Validasi panjang password
            if (newPassword.length() < 5) {
                JOptionPane.showMessageDialog(view, "Password harus minimal 5 karakter!");
                return;
            }
            
            // Validasi harus ada 1 angka
            if (!newPassword.matches(".*\\d.*")) { // \\d = digit (0-9)
                JOptionPane.showMessageDialog(view, "Password harus mengandung minimal 1 angka!");
                return;
            }

            // Validasi kesesuaian password
            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(view, "Password dan konfirmasi password tidak cocok!");
                return;
            }

            // Ambil data pengguna dari session
            Kurir currentUser = SessionManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(view, "Tidak ada pengguna yang sedang login.");
                return;
            }

            // Hash password baru
            String hashedPassword = hashPassword(newPassword);

            // Update password di database
            currentUser.setPassword(hashedPassword);
            mapper.updateKurir(currentUser);
            session.commit();

            JOptionPane.showMessageDialog(view, "Password berhasil diperbarui!");

            Menu menuView = new Menu(mapper, session);
            MenuController menuController = new MenuController(menuView, mapper, session);
            menuView.setVisible(true);

            // Tutup halaman GantiPassword
            view.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat mengubah password: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private String hashPassword(String password) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
