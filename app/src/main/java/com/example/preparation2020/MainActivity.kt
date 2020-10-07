package com.example.preparation2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.preparation2020.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    private var viewBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding?.activityInstance = this
        viewBinding?.resourceProvider = ResourceProvider()
        Log.d(TAG, "BUILD VERSION:  " + BuildConfig.VERSION_CODE)
    }
}