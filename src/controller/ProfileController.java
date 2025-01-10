package controller;

import javax.swing.JOptionPane;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.EditProfile;
import view.Profile;

public class ProfileController {
    private Profile view;
    private KurirMapper mapper;
    private SqlSession session;

    public ProfileController(Profile view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;
        loadUserData(); 
    }

    private void loadUserData() {
        // Ambil data pengguna dari session manager
        Kurir currentUser = SessionManager.getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("Tidak ada pengguna yang sedang login.");
        }

        // Tampilkan data pengguna ke label
        view.setNamaUser(currentUser.getName());
        view.setEmailUser(currentUser.getEmail());
        view.setAlamatUser(currentUser.getAddress());
        view.setNoTelpUser(currentUser.getNoTelp());
    }
    
    public void goToEditProfile() {
        EditProfile editProfile = new EditProfile(mapper, session);
        Kurir currentUser = SessionManager.getCurrentUser();

        // Isi data pengguna ke EditProfile
        editProfile.setNamaUser(currentUser.getName());
        editProfile.setEmailUser(currentUser.getEmail());
        editProfile.setAlamatUser(currentUser.getAddress());
        editProfile.setNoTelpUser(currentUser.getNoTelp());

        editProfile.setVisible(true);
        view.dispose(); // Tutup halaman Profile
    }

    

}
