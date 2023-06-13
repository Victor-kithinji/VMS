
package com.example.vms.ui.spareParts.mitsubishi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Mitsubishi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mitsubishi)

        val  mitsubishiBlowerMotor: Button =findViewById(R.id.mitsubishiBlowerMotorButton)
        val  mitsubishiIgnitionCoil: Button =findViewById(R.id.mitsubishiIgnitionCoilButton)
        val  mitsubishiRadiator: Button =findViewById(R.id.mitsubishiRadiatorButton)
        val  mitsubishiShaft: Button =findViewById(R.id.mitsubishiShaftButton)
        val  mitsubishiSpeedometer: Button =findViewById(R.id.mitsubishiSpeedometerButton)



    }
}