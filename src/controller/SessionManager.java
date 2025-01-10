package controller;

import model.Kurir;

public class SessionManager {
    private static Kurir currentUser;

    // Set sesi pengguna setelah login berhasil
    public static void setCurrentUser(Kurir user) {
        currentUser = user;
    }

    // Dapatkan sesi pengguna saat ini
    public static Kurir getCurrentUser() {
        return currentUser;
    }

    // Hapus sesi pengguna (saat logout)
    public static void clearSession() {
        currentUser = null;
    }

    // Periksa apakah ada pengguna yang login
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
