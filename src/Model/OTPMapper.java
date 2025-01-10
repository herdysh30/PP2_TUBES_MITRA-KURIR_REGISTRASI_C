package model;

import org.apache.ibatis.annotations.*;

public interface OTPMapper {

    @Insert("INSERT INTO otp (kode_otp, created_at, expires_at, status) VALUES (#{kodeOtp}, #{createdAt}, #{expiresAt}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "otpId")
    void insertOTP(OTP otp);

    @Select("SELECT otp_id, kode_otp, created_at, expires_at, status FROM otp WHERE kode_otp = #{kodeOtp}")
@Results({
    @Result(property = "otpId", column = "otp_id"),
    @Result(property = "kodeOtp", column = "kode_otp"),
    @Result(property = "createdAt", column = "created_at"),
    @Result(property = "expiresAt", column = "expires_at"),
    @Result(property = "status", column = "status")
})
OTP findByKodeOtp(String kodeOtp);

    
    @Update("UPDATE otp SET status = 'DIPAKAI' WHERE otp_id = #{otpId}")
    void updateStatus(int otpId);
}
