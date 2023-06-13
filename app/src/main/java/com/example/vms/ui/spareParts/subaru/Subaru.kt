package com.example.vms.ui.spareParts.subaru

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Subaru : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subaru)


        val  subaruCleaner: Button =findViewById(R.id.subaru_air_cleanerButton)
        val  subaruBrakePads: Button =findViewById(R.id.subaru_brake_padsButton)
        val  subaruOilFilter: Button =findViewById(R.id.subaru_oil_filterButton)
        val  subaruPlugs: Button =findViewById(R.id.subaru_plugsButton)
        val  subaruTailLight: Button =findViewById(R.id.subaru_tail_lightButton)




    }
}