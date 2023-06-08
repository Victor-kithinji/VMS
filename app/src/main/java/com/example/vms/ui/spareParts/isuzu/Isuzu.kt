package com.example.vms.ui.spareParts.isuzu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Isuzu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isuzu)


        val autoParts: Button = findViewById(R.id.autoPartsIsuzu)
        val carAccessories: Button = findViewById(R.id.carAccessoriesIsuzu)
        val autoEngine: Button = findViewById(R.id.autoEngineIsuzu)
        val electricalSystem: Button = findViewById(R.id.electricalSystemIsuzu)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesIsuzu)

        autoParts.setOnClickListener{
            val intent = Intent(this@Isuzu, IsuzuAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Isuzu, IsuzuAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Isuzu, IsuzuCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Isuzu, IsuzuElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Isuzu, IsuzuTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}