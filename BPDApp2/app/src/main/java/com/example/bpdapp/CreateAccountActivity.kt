package com.example.bpdapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_create.*

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        performRegister()
    }

    private fun performRegister() {
        create_account_create.setOnClickListener {
            val email = button_email_create.text.toString()
            val password = button_password_create.text.toString()

            if (email.isEmpty() || password.isEmpty()) return@setOnClickListener

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                }
                .addOnFailureListener {
                }
        }
    }
}