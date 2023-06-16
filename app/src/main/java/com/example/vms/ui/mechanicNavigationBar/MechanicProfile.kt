package com.example.vms.ui.mechanicNavigationBar

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.mechanicLogin.MechanicLoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MechanicProfile : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    var mechanicId: String? = null
    var mechanic: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_profile)

        databaseReference = FirebaseDatabase.getInstance().reference

        val mechanicName: TextView = findViewById(R.id.mechanicName)
        val mechanicEmail: TextView = findViewById(R.id.mechanicEmail)
        val profile: ImageView = findViewById(R.id.mechanic)
        val logout: ImageView = findViewById(R.id.logout3)
        val changePassword: TextView = findViewById(R.id.changeMechanicPassword)

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

            mechanicName.text = name
            mechanicEmail.text = email
        }


        logout.setOnClickListener {
            goToLogout()
        }
//        FirebaseAuth.getInstance().currentUser?.uid?.let { it ->
//            databaseReference.child("Mechanics").child(it)
//                .addValueEventListener(object : ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//                        if (snapshot.exists()) {
//                            val mechanic: com.example.vms.ui.mechanicRegister.Mechanic? = snapshot.getValue(com.example.vms.ui.mechanicRegister.Mechanic::class.java)
//                            mechanicName.text = mechanic?.name.toString()
//                            mechanicEmail.text = mechanic?.email.toString()
//                        } else {
//                            Toast.makeText(
//                                this@MechanicProfile,
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
        val intent = Intent(this@MechanicProfile, MechanicLoginActivity::class.java)
        startActivity(intent)
        finish()
        true
    }
}
