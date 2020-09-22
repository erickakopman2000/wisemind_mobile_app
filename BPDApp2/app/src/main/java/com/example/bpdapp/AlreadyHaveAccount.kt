package com.example.bpdapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class AlreadyHaveAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = text_email_login.text.toString()
        val password = text_password_login.text.toString()
        button_signin_login.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                .addOnCompleteListener {
                    val intent = Intent(this, CoursesActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {

                }
        }
    }
}