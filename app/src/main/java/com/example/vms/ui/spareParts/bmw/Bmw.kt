package com.example.vms.ui.spareParts.bmw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Bmw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmw)

        val autoParts: Button = findViewById(R.id.autoPartsBmw)
        val carAccessories: Button = findViewById(R.id.carAccessoriesBmw)
        val autoEngine: Button = findViewById(R.id.autoEngineBmw)
        val electricalSystem: Button = findViewById(R.id.electricalSystemBmw)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesBmw)

        autoParts.setOnClickListener{
            val intent = Intent(this@Bmw, BmwAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Bmw, BmwAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Bmw, BmwCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Bmw, BmwElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Bmw, BmwTireAccessories::class.java)
            startActivity(intent)
            finish()
        }

    }
}