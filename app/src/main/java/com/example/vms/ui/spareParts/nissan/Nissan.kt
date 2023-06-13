package com.example.vms.ui.spareParts.nissan

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Nissan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nissan)

        val  nissanControlArm: Button =findViewById(R.id.nissan_control_armButton)
        val  nissanHeadlight: Button =findViewById(R.id.nissan_headlightButton)
        val  nissanPlug: Button =findViewById(R.id.nissan_plugButton)
        val  nissanTieRod: Button =findViewById(R.id.nissanTieRodButton)


    }
}