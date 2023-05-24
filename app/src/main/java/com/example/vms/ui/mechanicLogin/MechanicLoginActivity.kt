package com.example.vms.ui.mechanicLogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.dashboard.MainActivity
import com.example.vms.ui.register.Register
import com.google.firebase.auth.FirebaseAuth

class MechanicLoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_login)
        val emailAddress: EditText =findViewById(R.id.editTextEmailAddressText)
        val mechanicPassword: EditText = findViewById(R.id.editTextPassword)
        val mechanicLogin: Button = findViewById(R.id.mechanicLogin)
        val accountLabel: TextView = findViewById(R.id.accountText)

        val firebaseAuth = FirebaseAuth.getInstance()
        fun login(view: View){
            val email = emailAddress.text.toString()
            val password = mechanicPassword.text.toString()
            if (email.isEmpty()) {
                emailAddress.error = ("Empty Email Address");
            } else if (password.isEmpty()) {
                mechanicPassword.error = ("Empty Password");
            } else if (password.length < 8) {
                mechanicPassword.error = ("Too weak password, use 8 characters");
            }else{
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
        mechanicLogin.setOnClickListener {
            val intent = Intent(this@MechanicLoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        accountLabel.setOnClickListener {
            val intent = Intent(this@MechanicLoginActivity, Register::class.java)
            startActivity(intent)
            finish()
        }
    }
}