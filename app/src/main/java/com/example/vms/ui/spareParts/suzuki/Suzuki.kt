
package com.example.vms.ui.spareParts.suzuki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Suzuki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suzuki)


        val autoParts: Button = findViewById(R.id.autoPartsSuzuki)
        val carAccessories: Button = findViewById(R.id.carAccessoriesSuzuki)
        val autoEngine: Button = findViewById(R.id.autoEngineSuzuki)
        val electricalSystem: Button = findViewById(R.id.electricalSystemSuzuki)
        val tireAccessories: Button = findViewById(R.id.tireAccessoriesSuzuki)

        autoParts.setOnClickListener{
            val intent = Intent(this@Suzuki, SuzukiAutoParts::class.java)
            startActivity(intent)
            finish()
        }
        autoEngine.setOnClickListener{
            val intent = Intent(this@Suzuki, SuzukiAutoEngine::class.java)
            startActivity(intent)
            finish()
        }
        carAccessories.setOnClickListener{
            val intent = Intent(this@Suzuki, SuzukiCarAccessories::class.java)
            startActivity(intent)
            finish()
        }
        electricalSystem.setOnClickListener{
            val intent = Intent(this@Suzuki, SuzukiElectricalSystem::class.java)
            startActivity(intent)
            finish()
        }
        tireAccessories.setOnClickListener{
            val intent = Intent(this@Suzuki, SuzukiTireAccessories::class.java)
            startActivity(intent)
            finish()
        }
    }
}