package com.example.vms.ui.spareParts.audi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Audi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audi)


        val audiClutch: Button = findViewById(R.id.audiclutchButton)
        val audiFilter: Button = findViewById(R.id.audiFilterButton)
        val audiHeadlight: Button = findViewById(R.id.audiHeadlightButton)
        val audiRadiator: Button = findViewById(R.id.audiRadiatorButton)
        val audiSparks: Button = findViewById(R.id.audiSparksButton)


    }
}