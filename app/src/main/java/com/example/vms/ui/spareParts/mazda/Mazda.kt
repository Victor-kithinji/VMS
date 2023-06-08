package com.example.vms.ui.spareParts.mazda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Mazda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mazda)

        val autoParts: Button = findViewById(R.id.autoPartsMazda)
        val carAccessories: Button = findViewById(R.id.carAccessoriesMazda)
        val autoEngine: Button = findViewById(R.id.autoEngineMazda)
        val electricalSystem: Button = findViewById(R.id.electricalSystemMazda)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesMazda)

        autoParts.setOnClickListener{
            val intent = Intent(this@Mazda, MazdaAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Mazda, MazdaAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Mazda, MazdaCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Mazda, MazdaElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Mazda, MazdaTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}