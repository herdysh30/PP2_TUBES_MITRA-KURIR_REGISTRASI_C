/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.MyBatisUtil;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.Register;
import controller.RegisterController;

public class Main {
    public static void main(String[] args){
        SqlSession session = MyBatisUtil.getSqlSession();
        KurirMapper mapper = session.getMapper(KurirMapper.class);
        
        Register view = new Register();
        RegisterController controller = new RegisterController(view, mapper, session);
        
        view.setVisible(true);
    }
}

