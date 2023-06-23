package com.example.vms.ui.dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.example.vms.ui.mechanicNavigationBar.MechanicProfile
import com.example.vms.ui.mechanicNavigationBar.MechanicRate
import com.example.vms.ui.spareParts.SpareParts
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class MechanicDashboard : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var map: GoogleMap
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var navView: NavigationView
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var dbReference: DatabaseReference = database.getReference("test")
    private lateinit var findLocationButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_dashboard)

        drawerLayout = findViewById(R.id.drawerLayout)
        val ivMenu: ImageButton = findViewById(R.id.imMenu)
        ivMenu.setOnClickListener {

            drawerLayout.openDrawer(GravityCompat.START)

            actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
            drawerLayout.addDrawerListener(actionBarToggle)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
            actionBarToggle.syncState()


            // Call findViewById on the NavigationView
            navView = findViewById(R.id.naView)


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
                    R.id.profile -> {
                        goToMechanicProfile()
                        true
                    }
                    R.id.rates -> {
                        goToRate()
                        true
                    }
                    R.id.logouts -> {
                        firebaseAuth = FirebaseAuth.getInstance()
                        firebaseAuth.signOut()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.dashboard -> {
                        goToUserDashboard()
                        true
                    }
                    R.id.brand -> {
                        goToSpareParts()
                        true
                    }
                    R.id.shares -> {
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
        val intent = Intent(Intent.ACTION_SEND)
        val shareBody = "Here is the share content body"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(2))
        intent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(intent, getString(2)))
    }

    private fun goToSpareParts() {
        val intent = Intent(this@MechanicDashboard, SpareParts::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToUserDashboard() {
        val intent = Intent(this@MechanicDashboard, MechanicDashboard::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRate() {
        val intent = Intent(this@MechanicDashboard, MechanicRate::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToMechanicProfile() {
        val intent = Intent(this@MechanicDashboard, MechanicProfile::class.java)
        startActivity(intent)
        finish()
    }

//    private val locListener = object : ValueEventListener {
//            //     @SuppressLint("LongLogTag")
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()) {
//                    //get the exact longitude and latitude from the database "test"
//                    val location = snapshot.child("test").getValue(LocationInfo::class.java)
//                    val locationLat = location?.latitude
//                    val locationLong = location?.longitude
//                    //trigger reading of location from database using the button
//                    findLocationButton.setOnClickListener {
//
//                        // check if the latitude and longitude is not null
//                        if (locationLat != null && locationLong != null) {
//                            // create a LatLng object from location
//                            val latLng = LatLng(locationLat, locationLong)
//                            //create a marker at the read location and display it on the map
//                            map.addMarker(
//                                MarkerOptions().position(latLng)
//                                    .title("The user is currently here")
//                            )
//                            //specify how the map camera is updated
//                            val update = CameraUpdateFactory.newLatLngZoom(latLng, 16.0f)
//                            //update the camera with the CameraUpdate object
//                            map.moveCamera(update)
//                        } else {
//                            // if location is null , log an error message
//                            Log.e(TAG, "user location cannot be found")
//                        }
//                    }
//
//                }
//            }
//
//            // show this toast if there is an error while reading from the database
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(
//                    applicationContext,
//                    "Could not read from database",
//                    Toast.LENGTH_LONG
//                )
//                    .show()
//            }
//
//        }
//
//        override fun onMapReady(googleMap: GoogleMap) {
//            map = googleMap //initialize map when the map is ready
//
//        }
//
//        companion object {
//            // TAG is passed into the Log.e methods used above to print information to the Logcat window
//            private const val TAG = "MechanicDashboard" // for debugging
//        }
}


