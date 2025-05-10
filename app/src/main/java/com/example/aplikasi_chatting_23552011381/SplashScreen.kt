package com.example.aplikasi_chatting_23552011381

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        val loginIntent: Intent = Intent(this, Login::class.java)

        // Wait 2 seconds before moving to login activity
        object : CountDownTimer(2000, 2000) {
            override fun onTick(millisUntilFinished: Long) {
                /*No implementation, just wait*/
            }
            override fun onFinish() {
                Log.i(getString(R.string.app_name), "Loading successful!")
                startActivity(loginIntent)
            }
        }.start()

    }
}