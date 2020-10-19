package com.example.preparation2020;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
// https://medium.com/@arie.valiant/java-cryptography-blowfish-encryption-decryption-tutorial-1db5f2cc15f1
public class MainActivity2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String encryption = null;
        try {
            encryption = EncryptionUtils.encrypt("gokul", "sukumar");
            Log.d("!!!! encryption", encryption);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String decrypt = EncryptionUtils.decrypt( "7m064ngzjRw=", "sukumar");
            Log.d("!!!! decrypt", decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}