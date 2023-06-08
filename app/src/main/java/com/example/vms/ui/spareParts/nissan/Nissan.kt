package com.example.vms.ui.spareParts.nissan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Nissan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nissan)


        val autoParts: Button = findViewById(R.id.autoPartsNissan)
        val carAccessories: Button = findViewById(R.id.carAccessoriesNissan)
        val autoEngine: Button = findViewById(R.id.autoEngineNissan)
        val electricalSystem: Button = findViewById(R.id.electricalSystemNissan)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesNissan)

        autoParts.setOnClickListener{
            val intent = Intent(this@Nissan, NissanAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Nissan, NissanAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Nissan, NissanCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Nissan, NissanElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Nissan, NissanTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}