package com.example.vms.ui.userNavigationBar

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class UserProfile : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    var userId: String? = null
    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val userName: TextView = findViewById(R.id.userName)
        val userEmail: TextView = findViewById(R.id.userEmail)
        val profile: ImageView = findViewById(R.id.person)
        val logout: ImageView = findViewById(R.id.logout2)


        logout.setOnClickListener{
            goToLogout()
        }

        fun fetchCurrentLoggedInUser() {
            databaseReference.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            val user: com.example.vms.ui.register.User? = snapshot.getValue(com.example.vms.ui.register.User::class.java)
                            userName.text = user?.name
                            userEmail.text = user?.email
                        } else {
                            Toast.makeText(
                                this@UserProfile,
                                "Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
        }
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
