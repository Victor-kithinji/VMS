package com.example.vms.ui.spareParts.volkswagen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Volkswagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volkswagen)


        val autoParts: Button = findViewById(R.id.autoPartsVolkswagen)
        val carAccessories: Button = findViewById(R.id.carAccessoriesVolkswagen)
        val autoEngine: Button = findViewById(R.id.autoEngineVolkswagen)
        val electricalSystem: Button = findViewById(R.id.electricalSystemVolkswagen)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesVolkswagen)

        autoParts.setOnClickListener{
            val intent = Intent(this@Volkswagen, VolkswagenAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Volkswagen, VolkswagenAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Volkswagen, VolkswagenCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Volkswagen, VolkswagenElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Volkswagen, VolkswagenTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}