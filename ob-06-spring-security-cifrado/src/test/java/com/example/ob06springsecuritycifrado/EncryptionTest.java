package com.example.ob06springsecuritycifrado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class EncryptionTest {

    /**
     * Bcrypt que genera su propio salt de 16 bytes
     *
     * El resultado de cifrar con bcrypt será un string de 60 caracteres:
     * - $a versión
     * - $10 fuerza (valor que va del 4 al 31, por defecto vale 10)
     * - Los 22 siguientes códigos son del salt
     */
    @Test
    void bcryptTest() {
        String password = "password";

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);

        boolean matches = encoder.matches(password, hashedPassword);
        Assertions.assertTrue(matches);
    }

    @Test
    void bcryptGenerationTest() {
        String password = "password";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 5; i++) {
            System.out.println(encoder.encode(password));
        }
    }

    @Test
    void pbkdf2Test() {
        String password = "password";

        PasswordEncoder encoder = new Pbkdf2PasswordEncoder(
                "S3cr3t",
                16,
                12,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256
        );

        String hashedPassword = encoder.encode(password);

        boolean matches = encoder.matches(password, hashedPassword);
        Assertions.assertTrue(matches);
    }

    @Test
    void pbkdf2GenerationTest() {
        String password = "password";

        PasswordEncoder encoder = new Pbkdf2PasswordEncoder(
                "S3cr3t",
                16,
                12,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256
        );

        for (int i = 0; i < 5; i++) {
            System.out.println(encoder.encode(password));
        }
    }
}
