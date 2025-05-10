package com.example.aplikasi_chatting_23552011381

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    private var username: String = "ramirez"
    private var password: String = "user123" // NEVER IF EVER USE THIS ANYWHERE ELSE BUT FOR TESTING REASONS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Get next activities (or self for extracting data from register activity)
        val listChatting: Intent = Intent(this, ListChatting::class.java)
        val register: Intent = Intent(this, Register::class.java)
        val login: Intent = intent

        // Get widgets
        val usernameField: EditText = findViewById(R.id.usernameField)
        val passwordField: EditText = findViewById(R.id.passwordField)
        val loginButton: Button = findViewById(R.id.loginButton)
        val registerButton: Button = findViewById(R.id.registerButton)

        // Check if this intent has data sent from register activity. If there's none, this will be skipped.
        if(login.hasExtra("username") && login.hasExtra("password")) {
            username = login.getStringExtra("username").toString()
            password = login.getStringExtra("password").toString()
            Log.i(getString(R.string.app_name), "Extras gotten")
        } else {
            Log.w(getString(R.string.app_name), "Extras missing! If you've not registered yet, ignore this message.")
        }

        // Get entered username and password from their respective text field

        loginButton.setOnClickListener {
            // Check if username or password matches
            val inputtedUsername: String = usernameField.getText().toString()
            val inputtedPassword: String = passwordField.getText().toString()

            if (inputtedUsername == username || inputtedPassword == password) {
                val successToast: Toast = Toast.makeText(this, getString(R.string.login_msgSuccess), Toast.LENGTH_SHORT)
                successToast.show()
                Log.i(getString(R.string.app_name), getString(R.string.login_msgSuccess))
                startActivity(listChatting)
            } else {
                val errToast: Toast = Toast.makeText(this, getString(R.string.login_msgInvalid), Toast.LENGTH_SHORT)
                errToast.show()
                Log.i(getString(R.string.app_name), getString(R.string.login_msgInvalid))
                Log.w(getString(R.string.app_name), "Expected username: ${username}. Got: ${inputtedUsername}")
                Log.w(getString(R.string.app_name), "Expected password: ${password}. Got: ${inputtedPassword}")
            }
        }

        registerButton.setOnClickListener {
            // Sends user to register activity
            Log.i(getString(R.string.app_name), "Register button clicked")
            startActivity(register)
        }


    }
}