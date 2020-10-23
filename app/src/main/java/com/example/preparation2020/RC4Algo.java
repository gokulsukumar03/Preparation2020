package com.example.preparation2020;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class RC4Algo {

    public void aliceEncrypt(byte[] plaintext, byte[] sharedSecret, Socket socket) {

        try {
            Cipher cipher = Cipher.getInstance("RC4/ECB/NoPadding");
            Key sk = new SecretKeySpec(sharedSecret, "RC4");
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            CipherOutputStream cos = new CipherOutputStream(socket.getOutputStream(), cipher);
            ObjectOutputStream oos = new ObjectOutputStream(cos);
            oos.writeObject(plaintext);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public byte[] bobDecrypt( byte[] sharedSecret, Socket socket) {


        try {
            Cipher cipher = Cipher.getInstance("RC4/ECB/NoPadding");
            Key sk = new SecretKeySpec(sharedSecret, "RC4");
            cipher.init(Cipher.DECRYPT_MODE, sk);
            CipherInputStream cis = new CipherInputStream(socket.getInputStream(), cipher);
            ObjectInputStream ois = new ObjectInputStream(cis);
            return (byte[]) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
