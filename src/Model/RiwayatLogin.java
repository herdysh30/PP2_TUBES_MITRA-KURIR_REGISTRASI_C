package model;

import java.time.LocalDateTime;

public class RiwayatLogin {
    private int id;
    private int kurirId;
    private String name;
    private String email;
    private LocalDateTime loginTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKurirId() {
        return kurirId;
    }

    public void setKurirId(int kurirId) {
        this.kurirId = kurirId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
