package com.example.vms.ui.spareParts.audi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Audi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audi)

        val autoParts: Button = findViewById(R.id.audiAutoParts)
        val carAccessories: Button = findViewById(R.id.audiCarAccessories)
        val autoEngine: Button = findViewById(R.id.audiAutoEngine)
        val electricalSystem: Button = findViewById(R.id.audiElectricalSystem)
        val tireAccessories: Button = findViewById(R.id.audiTireAccessories)

        autoParts.setOnClickListener{
            val intent = Intent(this@Audi, AudiAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Audi, AudiAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Audi, AudiCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Audi, AudiElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Audi, AudiTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}