package com.example.vms.ui.userNavigationBar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.spareParts.audi.Audi
import com.example.vms.ui.spareParts.benz.Benz
import com.example.vms.ui.spareParts.bmw.Bmw
import com.example.vms.ui.spareParts.ford.Ford
import com.example.vms.ui.spareParts.honda.Honda
import com.example.vms.ui.spareParts.isuzu.Isuzu
import com.example.vms.ui.spareParts.mazda.Mazda
import com.example.vms.ui.spareParts.mitsubishi.Mitsubishi
import com.example.vms.ui.spareParts.nissan.Nissan
import com.example.vms.ui.spareParts.peugeot.Peugeot
import com.example.vms.ui.spareParts.subaru.Subaru
import com.example.vms.ui.spareParts.suzuki.Suzuki
import com.example.vms.ui.spareParts.toyota.Toyota
import com.example.vms.ui.spareParts.volkswagen.Volkswagen

class Brands : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brands)

        val benz:ImageView = findViewById(R.id.benz)
        val audi:ImageView = findViewById(R.id.audi)
        val toyota:ImageView = findViewById(R.id.toyota)
        val mazda:ImageView = findViewById(R.id.mazda)
        val nissan:ImageView = findViewById(R.id.nissan2)
        val subaru:ImageView = findViewById(R.id.subaru)
        val bmw:ImageView = findViewById(R.id.bmw)
        val isuzu:ImageView = findViewById(R.id.isuzu)
        val volkswagen:ImageView = findViewById(R.id.volkswagen)
        val mitsubishi:ImageView = findViewById(R.id.mitsubishi)
        val ford:ImageView = findViewById(R.id.ford)
        val suzuki:ImageView = findViewById(R.id.suki)
        val peugeot:ImageView = findViewById(R.id.peugeot)
        val honda:ImageView = findViewById(R.id.honda)

        benz.setOnClickListener {
            val intent = Intent(this@Brands, Benz::class.java)
            startActivity(intent)
            finish()
        }
        audi.setOnClickListener {
            val intent =  Intent(this@Brands, Audi::class.java)
            startActivity(intent)
            finish()
        }
        toyota.setOnClickListener {
            val intent =  Intent(this@Brands, Toyota::class.java)
            startActivity(intent)
            finish()
        }
        mazda.setOnClickListener {
            val intent =  Intent(this@Brands, Mazda::class.java)
            startActivity(intent)
            finish()
        }
        nissan.setOnClickListener {
            val intent =  Intent(this@Brands, Nissan::class.java)
            startActivity(intent)
            finish()
        }
        subaru.setOnClickListener {
            val intent =  Intent(this@Brands, Subaru::class.java)
            startActivity(intent)
            finish()
        }
        bmw.setOnClickListener {
            val intent =  Intent(this@Brands, Bmw::class.java)
            startActivity(intent)
            finish()
        }
        isuzu.setOnClickListener {
            val intent =  Intent(this@Brands, Isuzu::class.java)
            startActivity(intent)
            finish()
        }
        volkswagen.setOnClickListener {
            val intent =  Intent(this@Brands, Volkswagen::class.java)
            startActivity(intent)
            finish()
        }
        mitsubishi.setOnClickListener {
            val intent =  Intent(this@Brands, Mitsubishi::class.java)
            startActivity(intent)
            finish()
        }
        ford.setOnClickListener {
            val intent =  Intent(this@Brands, Ford::class.java)
            startActivity(intent)
            finish()
        }
        suzuki.setOnClickListener {
            val intent =  Intent(this@Brands, Suzuki::class.java)
            startActivity(intent)
            finish()
        }
        peugeot.setOnClickListener {
            val intent =  Intent(this@Brands, Peugeot::class.java)
            startActivity(intent)
            finish()
        }
        honda.setOnClickListener {
            val intent =  Intent(this@Brands, Honda::class.java)
            startActivity(intent)
            finish()
        }
    }
}