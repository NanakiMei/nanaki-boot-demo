package com.nanaki.common;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/4/10
 */
public class PBKDF2Demo {
    // PBKDF2 参数
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 100000;
    private static final int KEY_LENGTH = 256;

    // 加密
    public static String encrypt(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }


    public static void main(String[] args) {
        try {
            String password = "mySecretPassword";
            String salt = "mysalt";

            // 加密
            String encryptedPassword = encrypt(password, salt);
            System.out.println("Encrypted password: " + encryptedPassword);
            // 加密
            String encryptedPassword2 = encrypt(password, salt);
            System.out.println("Encrypted password2: " + encryptedPassword2);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

}
