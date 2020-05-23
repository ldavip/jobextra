package br.com.kesley.jobextra.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private PasswordUtil() {
    }

    public static String encrypt(String text) {
        return new BCryptPasswordEncoder().encode(text);
    }
}