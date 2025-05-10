package com.example.aplikasi_chatting_23552011381

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListChatting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_chatting)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        try {
            val users: Array<String> = arrayOf("Bruno", "Celine", "Donny", "Tommy", "Zack" )
            val userList: ListView = findViewById(R.id.userList)
            val usersAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.list_user, users)
            userList.adapter = usersAdapter

            Log.i(getString(R.string.app_name), "Successfully loaded list chatting")
        } catch (e: IllegalStateException) {
            Log.e(getString(R.string.app_name), "Failed loading list chatting")
        }





    }
}