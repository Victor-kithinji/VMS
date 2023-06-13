package com.example.vms.ui.spareParts.bmw

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Bmw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmw)

        val bmwEngine: Button = findViewById(R.id.bmw_engineButton)
        val bmwBonnetHood: Button = findViewById(R.id.bmw_bonnet_hoodButton)
        val bmwAirCleaners: Button = findViewById(R.id.bmw_air_cleanersButton)
        val bmwAlternators: Button = findViewById(R.id.bmw_alternatorsButton)
        val bmwHeadlights: Button = findViewById(R.id.bmw_headlightsButton)
        val bmwSensors: Button = findViewById(R.id.bmw_sensorsButton)
        val bmwStarter: Button = findViewById(R.id.bmw_starterButton)



    }
}