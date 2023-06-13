package com.example.vms.ui.spareParts.honda

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Honda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_honda)


        val hondaStableLink: Button = findViewById(R.id.hondaStableLinkButton)
        val hondaPlugs: Button = findViewById(R.id.hondaPlugsButton)
        val hondaDoorMotor: Button = findViewById(R.id.hondaDoorMotorButton)



    }
}