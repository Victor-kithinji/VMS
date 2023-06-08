package com.example.vms.ui.spareParts.benz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Benz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benz)

        val autoParts: Button = findViewById(R.id.benzAutoParts)
        val carAccessories: Button = findViewById(R.id.benzCarAccessories)
        val autoEngine: Button = findViewById(R.id.autoEngineBenz)
        val electricalSystem: Button = findViewById(R.id.electricalSystemBenz)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesBenz)

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