package com.example.aplikasi_chatting_23552011381

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Send user straight to splash screen. This one will only be used as medium of interface.
        val splashScreenIntent = Intent(this, SplashScreen::class.java)
        Log.i(getString(R.string.app_name), "App launched")
        startActivity(splashScreenIntent);
    }
}