package com.example.vms.ui.userNavigationBar

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class UserProfile : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)


        databaseReference = FirebaseDatabase.getInstance().reference

        val userName: TextView = findViewById(R.id.userName)
        val userEmail: TextView = findViewById(R.id.userEmail)
        val profile: ImageView = findViewById(R.id.person)
        val logout: ImageView = findViewById(R.id.logout2)


        logout.setOnClickListener{
            goToLogout()
        }
        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email

            // Check if user's email is verified
            val emailVerified = it.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid

            userName.text = name
            userEmail.text = email
        }

//        fun fetchCurrentLoggedInUser() {
//            databaseReference.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
//                .addValueEventListener(object : ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//                        if (snapshot.exists()) {
//                            val user: com.example.vms.ui.register.User? = snapshot.getValue(com.example.vms.ui.register.User::class.java)
//                            userName.text = user?.name
//                            userEmail.text = user?.email
//                        } else {
//                            Toast.makeText(
//                                this@UserProfile,
//                                "Error",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {}
//                })
//        }
    }

    private fun goToLogout() {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val intent = Intent(this@UserProfile, Login::class.java)
        startActivity(intent)
        finish()
        true
    }
}
