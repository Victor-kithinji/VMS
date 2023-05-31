package com.example.vms.ui.dashboard

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vms.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.navigation.NavigationView

class UserDashboard : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var map: GoogleMap


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
                        Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.rate -> {
                        Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.logout -> {
                        Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.notification -> {
                        Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.brands -> {
                        Toast.makeText(this, "Spare Brand", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.share -> {
                        Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }

        }
    }
}