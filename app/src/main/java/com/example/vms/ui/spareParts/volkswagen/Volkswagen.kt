package com.example.vms.ui.spareParts.volkswagen

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Volkswagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volkswagen)

        val  volkswagenCleaners: Button =findViewById(R.id.volkswagenCleanersButton)
        val  volkswagenDoor: Button =findViewById(R.id.volkswagenDoorButton)
        val  volkswagenFogLight: Button =findViewById(R.id.volkswagenFogLightButton)
        val  volkswagenSensors: Button =findViewById(R.id.volkswagenSensorsButton)


    }
}