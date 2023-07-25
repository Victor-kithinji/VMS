package com.example.vms.ui.userMechanic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.example.vms.ui.mechanicLogin.MechanicLoginActivity

class UserMechanicActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_mechanic)

        val userButton: Button = findViewById(R.id.userButton)
        val mechanic: Button = findViewById(R.id.mechanicButton)




        userButton.setOnClickListener {
            val intent = Intent(this@UserMechanicActivity, Login::class.java)
            startActivity(intent)
            finish()
        }
        mechanic.setOnClickListener {
            val intent = Intent(this@UserMechanicActivity, MechanicLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}