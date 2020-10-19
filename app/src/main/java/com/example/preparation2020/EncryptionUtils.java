package com.example.preparation2020;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.nio.charset.Charset;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {

    private static final String AES_MODE = "Blowfish";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String password, String key) throws Exception {
        byte[] KeyData = key.getBytes();
        SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, KS);
        String encryptedtext = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
        return encryptedtext;

    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static String decrypt(String encryptedtext, String key) throws Exception {
            byte[] KeyData = key.getBytes();
            SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
            byte[] ecryptedtexttobytes = Base64.getDecoder().decode(encryptedtext);
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, KS);
            byte[] decrypted = cipher.doFinal(ecryptedtexttobytes);
            String decryptedString = new String(decrypted, Charset.forName("UTF-8"));
            return decryptedString;

        }


}
