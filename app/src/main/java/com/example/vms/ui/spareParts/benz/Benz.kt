package com.example.vms.ui.spareParts.benz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.spareParts.toyota.*

class Benz : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benz)

        val autoParts: Button = findViewById(R.id.autoParts)
        val carAccessories: Button = findViewById(R.id.carAccessories)
        val autoEngine: Button = findViewById(R.id.autoEngine)
        val electricalSystem: Button = findViewById(R.id.electricalSystem)
        val tireAccessories: Button = findViewById(R.id.tireAccessories)

        autoParts.setOnClickListener{
            val intent = Intent(this@Benz, BenzAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Benz, BenzAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Benz, BenzCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Benz, BenzElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Benz, BenzTireAccessories::class.java)
            startActivity(intent)
            finish()
        }

    }
}