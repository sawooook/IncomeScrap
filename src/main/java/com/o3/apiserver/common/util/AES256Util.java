package com.o3.apiserver.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES256Util {

    private static final byte[] key = "01234567890123456789012345678901".getBytes(StandardCharsets.UTF_8);
    private static final String ALGORITHM = "AES";

    public static AES256Util instance = new AES256Util();

    public String encrypt(String plainText) {
        try {
            return Base64.getEncoder().encodeToString(this.encrypt(plainText.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new IllegalArgumentException("암호화 할 수 없습니다");
        }
    }

    public String decrypt(String text) {
        try {

            return new String(decrypt(Base64.getDecoder().decode(text)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException("복호화 할 수 없습니다");
        }
    }

    private byte[] encrypt(byte[] plainText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    private byte[] decrypt(byte[] cipherText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
}