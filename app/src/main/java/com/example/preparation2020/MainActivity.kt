package com.example.preparation2020


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        val curvedBottomNavigationView: CurvedBottomNavigationView = findViewById(R.id.customBottomBar)
        curvedBottomNavigationView.inflateMenu(R.menu.bottom_menu)
    }
}