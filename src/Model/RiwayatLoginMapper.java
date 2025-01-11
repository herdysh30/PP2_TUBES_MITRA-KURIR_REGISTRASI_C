package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface RiwayatLoginMapper {

    @Insert("INSERT INTO riwayat_login (kurir_id, login_time) VALUES (#{kurirId}, #{loginTime})")
    void insertRiwayatLogin(@Param("kurirId") int kurirId, @Param("loginTime") String loginTime);

    @Select("""
    SELECT rl.id, rl.kurir_id, rl.login_time, k.name, k.email
    FROM riwayat_login rl
    INNER JOIN kurir k ON rl.kurir_id = k.id
    """)
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "kurirId", column = "kurir_id"),
        @Result(property = "loginTime", column = "login_time"),
        @Result(property = "name", column = "name"),
        @Result(property = "email", column = "email")
    })
    List<RiwayatLogin> getAllRiwayatLogin();

}
