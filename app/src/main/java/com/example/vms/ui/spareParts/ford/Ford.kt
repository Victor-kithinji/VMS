
package com.example.vms.ui.spareParts.ford

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Ford : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ford)


        val autoParts: Button = findViewById(R.id.autoParts)
        val carAccessories: Button = findViewById(R.id.carAccessories)
        val autoEngine: Button = findViewById(R.id.autoEngine)
        val electricalSystem: Button = findViewById(R.id.electricalSystem)
        val tireAccessories: Button = findViewById(R.id.tireAccessories)

        autoParts.setOnClickListener{
            val intent = Intent(this@Ford, FordAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Ford, FordaAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Ford, FordCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Ford, FordElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Ford, FordTireAccessories::class.java)
            startActivity(intent)
            finish()
        }


    }
}