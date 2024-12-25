/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;


import java.util.List;
import org.apache.ibatis.annotations.*;

public interface KurirMapper {
    @Select("SELECT * FROM kurir")
    List<Kurir> getAllUsers();

    @Insert("INSERT INTO kurir (name,noTelp,address,email,password) VALUES (#{name}, #{noTelp}, #{address}, #{email}, #{password})")
    void insertKurir(Kurir kurir);
    
    @Update("UPDATE kurir SET name = #{name}, noTelp = #{noTelp}, address = #{address}, email = #{email}, password = #{password} WHERE id = #{id}")
    void updateKurir(Kurir kurir); 

    @Delete("DELETE FROM kurir WHERE id = #{id}")
    void deleteKurir(int id);
}
