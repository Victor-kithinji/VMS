package com.example.vms.ui.spareParts.honda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Honda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_honda)


        val autoParts: Button = findViewById(R.id.autoPartsHonda)
        val carAccessories: Button = findViewById(R.id.carAccessoriesHonda)
        val autoEngine: Button = findViewById(R.id.autoEngineHonda)
        val electricalSystem: Button = findViewById(R.id.electricalSystemHonda)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesHonda)

        autoParts.setOnClickListener{
            val intent = Intent(this@Honda, HondaAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Honda, HondaAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Honda, HondaCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Honda, HondaElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Honda, HondaTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}