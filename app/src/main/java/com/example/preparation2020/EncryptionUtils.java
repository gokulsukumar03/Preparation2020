package com.example.preparation2020;

import android.content.Context;
import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {

        private static class EncyrptionUtilsHolder {
            private static final EncryptionUtils sInstance = new EncryptionUtils();
        }

        public static EncryptionUtils getInstance() {
            return EncyrptionUtilsHolder.sInstance;
        }

        private static final String AES_MODE = "RC4/ECB/NoPadding";

        private Key getSecretKey(Context context){
            byte[] packageNameBytes = context.getPackageName().getBytes();
            byte[] smartKey = new byte[32];

            for (int i = 0; i < smartKey.length; i++) {
                byte packageNameByte = i < packageNameBytes.length ? packageNameBytes[i] : 0;
                smartKey[i] = packageNameByte;
            }
            return new SecretKeySpec(smartKey, "RC4");
        }


        public String encrypt(Context context, byte[] input) throws Exception {
            Cipher c = Cipher.getInstance(AES_MODE);
            c.init(Cipher.ENCRYPT_MODE, getSecretKey(context));
            byte[] encodedBytes = c.doFinal(input);
            return Base64.encodeToString(encodedBytes, Base64.DEFAULT);
        }


        public byte[] decrypt(Context context, byte[] encrypted) throws Exception {
            Cipher c = Cipher.getInstance(AES_MODE);
            c.init(Cipher.DECRYPT_MODE, getSecretKey(context));
            return c.doFinal(encrypted);
        }

}
