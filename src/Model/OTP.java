package model;

import java.time.LocalDateTime;

public class OTP {
    private int otpId; // otp_id
    private String kodeOtp; // kode_otp
    private LocalDateTime createdAt; // created_at
    private LocalDateTime expiresAt; // expires_at
    private String status; // status

    // Getters dan Setters
    public int getOtpId() {
        return otpId;
    }

    public void setOtpId(int otpId) {
        this.otpId = otpId;
    }

    public String getKodeOtp() {
        return kodeOtp;
    }

    public void setKodeOtp(String kodeOtp) {
        this.kodeOtp = kodeOtp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
