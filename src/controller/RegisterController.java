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

public class RegisterController {
    private Register view;
    private KurirMapper mapper;
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

            if (!name.isEmpty() && !email.isEmpty() && !noTelp.isEmpty() && !address.isEmpty()&& !password.isEmpty()  ) {
                Kurir kurir = new Kurir();
                kurir.setName(name);
                kurir.setEmail(email);
                kurir.setNoTelp(noTelp);
                kurir.setAddress(address);
                kurir.setPassword(password);

                mapper.insertKurir(kurir);
                session.commit();
                JOptionPane.showMessageDialog(view, "Customer added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }
    
}
