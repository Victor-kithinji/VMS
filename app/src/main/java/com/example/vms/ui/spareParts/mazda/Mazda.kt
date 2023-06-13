package com.example.vms.ui.spareParts.mazda

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Mazda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mazda)

        val  mazdaStabilityLink: Button =findViewById(R.id.mazdaStabilityLinkButton)
        val  mazdaAirFilter: Button =findViewById(R.id.mazda_airFilterButton)
        val  mazdaBrakesPads: Button =findViewById(R.id.mazdaBrakesPadsButton)
        val  mazdaPlugs: Button =findViewById(R.id.mazdaPlugsButton)
        val  mazdaSensors: Button =findViewById(R.id.mazdaSensorsButton)
    }
}