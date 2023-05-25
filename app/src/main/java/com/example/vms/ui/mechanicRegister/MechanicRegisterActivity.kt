package com.example.vms.ui.mechanicRegister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.mechanicLogin.MechanicLoginActivity
import com.example.vms.ui.register.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MechanicRegisterActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_register)


        val fullNameLabel: EditText = findViewById(R.id.mechanicFullNameLabel)
        val emailAddressLabel: EditText = findViewById(R.id.editTextTextEmailAddressLabel)
        val phoneNumber: EditText = findViewById(R.id.editTextPhoneLabel)
        val passwordLabel: EditText = findViewById(R.id.editTextTextPassword)
        val registerButton: Button = findViewById(R.id.RegisterLabel)
        val haveAccount: TextView = findViewById(R.id.dontHaveAccountLabel)

        firebaseAuth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("Mechanics")

        registerButton.setOnClickListener {


            val email = emailAddressLabel.text.toString()
            val password = passwordLabel.text.toString()
            val fullName = fullNameLabel.text.toString()
            val phone = phoneNumber.text.toString()


            if (fullName.isEmpty()) {
                fullNameLabel.error = "Empty Username"
            } else if (phone.isEmpty()) {
                phoneNumber.error = ("Empty Phone Number")
            } else if (email.isEmpty()) {
                emailAddressLabel.error = ("Empty Email Address")
            } else if (password.isEmpty()) {
                passwordLabel.error = ("Empty Password")
            } else if (password.length < 8) {
                passwordLabel.error = ("Too weak password, use 8 characters")
            } else {

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val userId = firebaseAuth.currentUser?.uid
                            val user = User(password, email, phone, fullName)

                            databaseReference.child(userId!!).setValue(user)

                            goToLogin()
                        }

                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            applicationContext,
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }

                haveAccount.setOnClickListener {
                    val intent =
                        Intent(this@MechanicRegisterActivity, MechanicLoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }


    }

    private fun goToLogin() {
        val intent = Intent(this, MechanicLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
