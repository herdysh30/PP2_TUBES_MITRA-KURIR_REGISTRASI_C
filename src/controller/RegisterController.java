/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.Register;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import view.OTP;

public class RegisterController {
    private Register view;
    private KurirMapper mapper;
    private OTP viewOTP;
    private SqlSession session;

    public RegisterController(Register view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;
        
        view.buttonDaftarListener(new ButtonDaftarListener());
    }
    class ButtonDaftarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String noTelp = view.getNoTelpInput();
            String address = view.getAdressInput();
            String email = view.getEmailInput();
            String password = view.getPasswordInput();
            String konpassword = view.getKonPasswordInput();
            
            if (!password.equals(konpassword)) {
                JOptionPane.showMessageDialog(view, "Password dan konfirmasi password tidak cocok.");
                return; 
            }
            
            Kurir existingKurir = mapper.findKurirByEmail(email);
                 if (existingKurir != null) {
                JOptionPane.showMessageDialog(view, "Email sudah terdaftar ! Gunakan Email Lain");
                return; 
            }

            // Validasi form tidak boleh kosong
        if (name.isEmpty() || email.isEmpty() || noTelp.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Lengkapi Semua Formulirnya !");
            return;
        }
        
        view.setVisible(false);  
        viewOTP = new OTP();  
        viewOTP.setVisible(true);  
        
        viewOTP.setKurirData(mapper, session, name, email, password, noTelp, address);
            
            
        }
    }
    
}
