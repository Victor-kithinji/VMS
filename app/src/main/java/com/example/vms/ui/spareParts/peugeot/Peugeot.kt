
package com.example.vms.ui.spareParts.peugeot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Peugeot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peugeot)



        val autoParts: Button = findViewById(R.id.autoPartsPeugeot)
        val carAccessories: Button = findViewById(R.id.carAccessoriesPeugeot)
        val autoEngine: Button = findViewById(R.id.autoEnginePeugeot)
        val electricalSystem: Button = findViewById(R.id.electricalSystemPeugeot)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesPeugeot)

        autoParts.setOnClickListener{
            val intent = Intent(this@Peugeot, PeugeotAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Peugeot, PeugeotAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Peugeot, PeugeotCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Peugeot, PeugeotElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Peugeot, PeugeotTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}