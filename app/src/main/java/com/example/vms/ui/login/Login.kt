package com.example.vms.ui.login

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

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button2: Button =findViewById(R.id.button)
        val password2: EditText = findViewById(R.id.password)
        val emailAddress: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.dontHaveaccountText)

        val firebaseAuth = FirebaseAuth.getInstance()
        fun login(view: View){
            val email = emailAddress.text.toString()
            val password = password2.text.toString()
            if (email.isEmpty()) {
                emailAddress.error = ("Empty Email Address");
            } else if (password.isEmpty()) {
                password2.error = ("Empty Password");
            } else if (password.length < 8) {
                password2.error = ("Too weak password, use 8 characters");
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
        button2.setOnClickListener {
            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        textView2.setOnClickListener {
            val intent =Intent(this@Login, Register::class.java)
            startActivity(intent)
            finish()
        }
    }
}