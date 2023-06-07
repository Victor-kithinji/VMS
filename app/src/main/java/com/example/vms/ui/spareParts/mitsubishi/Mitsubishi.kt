
package com.example.vms.ui.spareParts.mitsubishi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.spareParts.toyota.*

class Mitsubishi : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mitsubishi)


        val autoParts: Button = findViewById(R.id.autoParts)
        val carAccessories: Button = findViewById(R.id.carAccessories)
        val autoEngine: Button = findViewById(R.id.autoEngine)
        val electricalSystem: Button = findViewById(R.id.electricalSystem)
        val tireAccessories: Button = findViewById(R.id.tireAccessories)

        autoParts.setOnClickListener{
            val intent = Intent(this@Mitsubishi, MitsubishiAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Mitsubishi, MitsubishiAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Mitsubishi, MitsubishiCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Mitsubishi, MitsubishiElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Mitsubishi, MitsubishiTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}