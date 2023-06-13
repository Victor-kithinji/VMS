package com.example.vms.ui.spareParts.isuzu

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Isuzu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isuzu)

        val isuzuCompressor: Button = findViewById(R.id.isuzuCompressorButton)
        val isuzuFenders: Button = findViewById(R.id.isuzuFendersButton)
        val isuzuShift: Button = findViewById(R.id.isuzuShiftButton)
        val isuzuWheel: Button = findViewById(R.id.isuzuWheelButton)


    }
}