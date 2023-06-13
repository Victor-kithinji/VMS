
package com.example.vms.ui.spareParts.ford

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Ford : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ford)


        val fordCondenser: Button = findViewById(R.id.fordCondesorButton)
        val fordFanShroud: Button = findViewById(R.id.fordFanShroudButton)
        val fordFrontDoor: Button = findViewById(R.id.fordFrontDoorButton)
        val fordSpareTank: Button = findViewById(R.id.fordsparetankButton)


    }
}