
package com.example.vms.ui.spareParts.peugeot

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Peugeot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peugeot)

        val  peugeotBonnetHood: Button =findViewById(R.id.peugeot_bonnet_hoodButton)
        val  peugeotCondenser: Button =findViewById(R.id.peugeot_condensorButton)
        val  peugeotDoorAutoGlass: Button =findViewById(R.id.peugeot_door_auto_glassButton)
        val  peugeotFenders: Button =findViewById(R.id.peugeot_fendersButton)
        val  peugeotFuelInjectors: Button =findViewById(R.id.peugeot_fuel_injectorsButton)



    }
}