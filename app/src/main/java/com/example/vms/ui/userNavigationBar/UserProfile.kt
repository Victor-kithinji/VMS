package com.example.vms.ui.userNavigationBar

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class UserProfile : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)


        val userName: TextView = findViewById(R.id.userName)
        val userEmail: TextView = findViewById(R.id.userEmail)
        val profile: ImageView = findViewById(R.id.person)
        val logout: ImageView = findViewById(R.id.logout2)


        logout.setOnClickListener {
            goToLogout()
        }
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            userEmail.text = user.email
            userName.text = user.displayName
        }

    }

    private fun goToLogout() {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val intent = Intent(this@UserProfile, Login::class.java)
        startActivity(intent)
        finish()
    }
}
