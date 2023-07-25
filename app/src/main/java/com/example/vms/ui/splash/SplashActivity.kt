package com.example.vms.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.dashboard.UserDashboard
import com.example.vms.ui.login.Login
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        val userLoggedIn = FirebaseAuth.getInstance().currentUser



        Handler().postDelayed({

            if (userLoggedIn == null) {
                val intent = Intent(this@SplashActivity, Login::class.java)
                startActivity(intent)
                finish()
            }
            else {
                val intent = Intent(this@SplashActivity, UserDashboard::class.java)
                startActivity(intent)
                finish()
            }

        },3000)
    }
}