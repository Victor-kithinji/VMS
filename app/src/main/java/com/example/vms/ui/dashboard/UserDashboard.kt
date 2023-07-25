package com.example.vms.ui.dashboard

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vms.R
import com.example.vms.ui.login.Login
import com.example.vms.ui.spareParts.SpareParts
import com.example.vms.ui.userNavigationBar.Rate
import com.example.vms.ui.userNavigationBar.UserProfile
import com.example.vms.ui.userNavigationBar.UserReminder
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserDashboard : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private var  location : Location? = null

    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)


        val findLocation = findViewById<Button>(R.id.btn_find_location)

        findLocation.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW)
            browserIntent.data = Uri.parse("https://www.google.com/maps/search/mechanics+near+me")
            startActivity(browserIntent)
        }


        val latitude = location?.latitude
        val longitude = location?.longitude

        databaseReference = FirebaseDatabase.getInstance().reference

        val locationRef = databaseReference.child("user-location")

        drawerLayout = findViewById(R.id.drawerLayout)
        val ivMenu: ImageButton = findViewById(R.id.IvMenu)

//        val saveLocationInfo = findViewById<Button>(R.id.btn_find_location)


        val location = latitude?.let {
            if (longitude != null) {
                LatLng(it, longitude)
            }
        }


        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

            //initializeMap()
            val mapView = findViewById<MapView>(R.id.mapView)
            mapView.onCreate(savedInstanceState)
            mapView.getMapAsync { googleMap ->
                // Map initialization code
                googleMap.isMyLocationEnabled = true
                googleMap.uiSettings.isMyLocationButtonEnabled = true
                // Add more map configuration and customization if needed
            }

        } else {
            // Location permission is not granted, request the permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }


        // Button to save location to db
//        saveLocationInfo.setOnClickListener {
//            locationRef.push().setValue(location)
//        }

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



    private fun goToShare() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share))
        startActivity(Intent.createChooser(intent, getString(R.string.share)))
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

    private fun goToUserNotification() {
        val intent = Intent(this@UserDashboard, UserReminder::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val latitude = 0.557890
        val longitude = 34.55600
        val location = LatLng(latitude, longitude)
        googleMap.addMarker(
            MarkerOptions().position(location)
                .title("You are here. Please check your nearest Mechanic")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))

    }
}
