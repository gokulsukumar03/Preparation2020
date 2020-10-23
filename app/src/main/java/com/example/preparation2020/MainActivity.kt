package com.example.preparation2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var test = EncryptionUtils.getInstance().encrypt(this, "sukumar".toByteArray())
        Log.d("!!!! test" , test)


        var test2 =  String(EncryptionUtils.getInstance().decrypt(this, Base64.decode("3dCwCU8bSw==", Base64.DEFAULT)));
        Log.d("!!! de" , test2)
    }
}