package com.tp.cbon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val email = intent.getStringExtra("email")
        lateinit var txtWelcome : TextView
        txtWelcome=findViewById(R.id.txtWelcome)
        txtWelcome.text="Bienvenue $email"


    }
}