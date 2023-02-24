package com.example.aa_android_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class LoggedInActivity : AppCompatActivity() {

    lateinit var enteredText: TextView
    lateinit var enteredAboutIcon : TextView
    lateinit var enteredWelcomeIcon: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        enteredText = findViewById(R.id.About)

        val user: String = intent.getStringExtra("username").toString()
        enteredText.text = "Hello $user!"

        enteredAboutIcon = findViewById(R.id.about_intent)
        enteredWelcomeIcon = findViewById(R.id.welcome_intent)

        var intentAbout = Intent(this, AboutActivity::class.java)
        enteredAboutIcon.setOnClickListener {
            startActivity(intentAbout)
        }
        var intentWelcome = Intent(this, MainActivity::class.java)
        enteredWelcomeIcon.setOnClickListener {
            startActivity(intentWelcome)
        }
    }


}