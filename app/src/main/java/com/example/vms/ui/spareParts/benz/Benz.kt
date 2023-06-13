package com.example.vms.ui.spareParts.benz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Benz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benz)

        val benzOilFilter: Button = findViewById(R.id.benzOilFilterButton)
        val benzSensors: Button = findViewById(R.id.benzSensorsButton)
        val benzWiperMotor: Button = findViewById(R.id.benzWiperMotorButton)
        val benzWipers: Button = findViewById(R.id.benzWipersButton)



    }
}