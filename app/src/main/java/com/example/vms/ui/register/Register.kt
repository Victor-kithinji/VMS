package com.example.vms.ui.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val textView: TextView = findViewById(R.id.fullNameLabel)
        val phoneLabel: EditText = findViewById(R.id.phoneLabel)
        val emailAddressLabel: EditText = findViewById(R.id.emailAddressLabel)
        val passwordLabel: EditText = findViewById(R.id.passwordLabel)
        val registerLabel: Button = findViewById(R.id.registerLabel)
        val alreadyHaveAccount: EditText = findViewById(R.id.alreadyHaveAccount)

        val firebaseAuth = FirebaseAuth.getInstance()
        val email = emailAddressLabel.text.toString()
        val password = passwordLabel.text.toString()
        val fullName = textView.text.toString()
        val phone = phoneLabel.text.toString()



        if (fullName.isEmpty()) {
            textView.error = "Empty Username";
        } else if (phone.isEmpty()) {
            phoneLabel.error = ("Empty Phone Number");
        } else if (email.isEmpty()) {
            emailAddressLabel.error = ("Empty Email Address");
        } else if (password.isEmpty()) {
            passwordLabel.error = ("Empty Password");
        } else if (password.length < 8) {
            passwordLabel.error = ("Too weak password, use 8 characters");
        } else {

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = firebaseAuth.currentUser?.uid
                        val user = User(password, email, phone, fullName)
                       goToLogin()
                    }

                }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }

            registerLabel.setOnClickListener {
                val intent = Intent(this@Register, Login::class.java)
                startActivity(intent)
                finish()
            }
            alreadyHaveAccount.setOnClickListener {
                val intent = Intent(this@Register, Login::class.java)
                startActivity(intent)
                finish()
            }


        }
    }

    private fun goToLogin() {
        val intent = Intent(this@Register, Login::class.java)
        startActivity(intent)
        finish()
    }
}
