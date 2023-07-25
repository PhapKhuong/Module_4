package com.account.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class EncryptedPasswordUtils {
    private EncryptedPasswordUtils() {
    }
    // Method để mã hoà password
    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    // chạy test để mã hoá password
    public static void main(String[] args) {
        String password = "2021";
        String encryptedPassword = encryptedPassword(password);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}
