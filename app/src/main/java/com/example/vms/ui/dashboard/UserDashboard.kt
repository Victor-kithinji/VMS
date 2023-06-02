package com.example.vms.ui.dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.example.vms.ui.userNavigationBar.Rate
import com.example.vms.ui.userNavigationBar.SpareParts
import com.example.vms.ui.userNavigationBar.UserNotification
import com.example.vms.ui.userNavigationBar.UserProfile
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class UserDashboard : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var map: GoogleMap
    private lateinit var firebaseAuth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)


        drawerLayout = findViewById(R.id.drawerLayout)
        val ivMenu: ImageButton = findViewById(R.id.IvMenu)

        ivMenu.setOnClickListener {

            drawerLayout.openDrawer(GravityCompat.START)

            actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
            drawerLayout.addDrawerListener(actionBarToggle)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
            actionBarToggle.syncState()


            // Call findViewById on the NavigationView
            navView = findViewById(R.id.navView)


            fun onSupportNavigateUp(): Boolean {
                drawerLayout.openDrawer(navView)
                return true
            }

            // override the onBackPressed() function to close the Drawer when the back button is clicked
            fun onBackPressed() {
                if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    this.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    super.onBackPressed()
                }
            }

            // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
            navView.setNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.login -> {
                        goToUserProfile()
                        true
                    }
                    R.id.rate -> {
                        goToRate()
                        true
                    }
                    R.id.logout -> {
                        firebaseAuth = FirebaseAuth.getInstance()
                        firebaseAuth.signOut()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.notification -> {
                        goToUserNotification()
                        true
                    }
                    R.id.brands -> {
                        goToSpareParts()
                        true
                    }
                    R.id.share -> {
                        goToShare()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }

        }
    }

    @SuppressLint("ResourceType")
    private fun goToShare() {
        val intent = Intent(android.content.Intent.ACTION_SEND)
        val shareBody = "Here is the share content body"
        intent.type = "text/plain"
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(2))
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(intent, getString(2)))
    }

    private fun goToSpareParts() {
        val intent = Intent(this@UserDashboard, SpareParts::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRate() {
            val intent = Intent(this@UserDashboard, Rate::class.java)
            startActivity(intent)
            finish()

        }

        private fun goToUserProfile() {
            val intent = Intent(this@UserDashboard, UserProfile::class.java)
            startActivity(intent)
            finish()

        }
    private fun goToUserNotification(){
        val intent = Intent(this@UserDashboard, UserNotification::class.java)
    }
}
