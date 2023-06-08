package com.example.vms.ui.spareParts.subaru

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Subaru : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subaru)



        val autoParts: Button = findViewById(R.id.autoPartsSubaru)
        val carAccessories: Button = findViewById(R.id.carAccessoriesSubaru)
        val autoEngine: Button = findViewById(R.id.autoEngineSubaru)
        val electricalSystem: Button = findViewById(R.id.electricalSystemSubaru)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesSubaru)

        autoParts.setOnClickListener{
            val intent = Intent(this@Subaru, SubaruAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Subaru, SubaruAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Subaru, SubaruCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Subaru, SubaruElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Subaru, SubaruTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}