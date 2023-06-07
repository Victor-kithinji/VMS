package com.example.vms.ui.spareParts.toyota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Toyota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toyota)

        val autoParts:Button = findViewById(R.id.autoParts)
        val carAccessories:Button = findViewById(R.id.carAccessories)
        val autoEngine:Button = findViewById(R.id.autoEngine)
        val electricalSystem:Button = findViewById(R.id.electricalSystem)
        val tireAccessories:Button = findViewById(R.id.tireAccessories)

        autoParts.setOnClickListener{
            val intent = Intent(this@Toyota, ToyotaAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Toyota, ToyotaAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Toyota, ToyotaCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Toyota, ToyotaElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Toyota, ToyotaTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}