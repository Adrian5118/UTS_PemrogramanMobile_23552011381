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

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        val login: Intent = Intent(this, Login::class.java)

        val usernameField: EditText = findViewById(R.id.usernameField)
        val passwordField: EditText = findViewById(R.id.passwordField)

        val registerButton: Button = findViewById(R.id.registerButton)
        val backButton: Button = findViewById(R.id.backButton)

        registerButton.setOnClickListener {
            val inputtedUsername: String = usernameField.getText().toString()
            val inputtedPassword: String = passwordField.getText().toString()

            // If neither of them are empty, send data to login activity then send user to login page with these data
            if (inputtedUsername.isNotBlank() || inputtedPassword.isNotBlank()) {
                login.putExtra("username", inputtedUsername)
                login.putExtra("password", inputtedPassword)

                val successToast: Toast = Toast.makeText(this, getString(R.string.register_msgSuccess), Toast.LENGTH_SHORT)
                successToast.show()
                Log.i(getString(R.string.app_name), getString(R.string.register_msgSuccess))
                startActivity(login)
            } else {
                val emptyToast: Toast = Toast.makeText(this, getString(R.string.register_msgEmpty), Toast.LENGTH_SHORT)
                emptyToast.show()
                Log.i(getString(R.string.app_name), getString(R.string.register_msgEmpty))
            }
        }

        // Send user back to login activity if back button is clicked
        backButton.setOnClickListener {
            Log.i(getString(R.string.app_name), "Register cancelled")
            finish()
        }
    }
}