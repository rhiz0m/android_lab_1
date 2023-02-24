package com.example.aa_android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var passWord : EditText
    lateinit var loginBtn : Button
    lateinit var resultMsg : TextView
    lateinit var passWordBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userName = findViewById(R.id.overlay_view)
        passWord = findViewById(R.id.editPassWord)
        loginBtn = findViewById(R.id.signin_btn)
        passWordBtn = findViewById(R.id.password_generator)
        resultMsg = findViewById(R.id.auth_msg)

        val authPassWord: Int = (100000..199999).random()

        passWordBtn.setOnClickListener {
            resultMsg.text = "Your unique login password is: $authPassWord"
        }

        loginBtn.setOnClickListener {

            val userName: String = userName.text.toString().trim()
            val passWord: String = passWord.text.toString()
            val authUsers = listOf("Asimov","Shelley", "Clarke", "LeGuin", "Herbert", "PKD", "Boye", "Gibson")

            val intent = Intent(this@LoginActivity, LoggedInActivity::class.java)

            for (authUser in authUsers) {

                if (userName == authUser && passWord.toInt() == authPassWord) {
                    intent.putExtra("username", userName)
                    startActivity(intent)
                } else if (userName.isEmpty()) {
                    resultMsg.text = "Please enter right credentials"
                } else if (passWord.trim().isEmpty()) {
                    resultMsg.text = "Please enter right credentials"
                } else if ((userName.isEmpty()) && (passWord.trim().isEmpty())) {
                    resultMsg.text = "Please enter right credentials"
                } else {
                    resultMsg.text = "Sorry can't find user. Please try again"
                }
            }
        }
    }
}