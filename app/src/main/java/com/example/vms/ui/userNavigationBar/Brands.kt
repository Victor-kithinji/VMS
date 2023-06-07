package com.example.vms.ui.userNavigationBar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

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
            val intent = Intent(this@Brands, benz::class.java)
            startActivity(intent)
            finish()
        }
        audi.setOnClickListener {
            val intent =  Intent(this@Brands, audi::class.java)
            startActivity(intent)
            finish()
        }
        toyota.setOnClickListener {
            val intent =  Intent(this@Brands, toyota::class.java)
            startActivity(intent)
            finish()
        }
        mazda.setOnClickListener {
            val intent =  Intent(this@Brands, mazda::class.java)
            startActivity(intent)
            finish()
        }
        nissan.setOnClickListener {
            val intent =  Intent(this@Brands, nissan::class.java)
            startActivity(intent)
            finish()
        }
        subaru.setOnClickListener {
            val intent =  Intent(this@Brands, subaru::class.java)
            startActivity(intent)
            finish()
        }
        bmw.setOnClickListener {
            val intent =  Intent(this@Brands, bmw::class.java)
            startActivity(intent)
            finish()
        }
        isuzu.setOnClickListener {
            val intent =  Intent(this@Brands, isuzu::class.java)
            startActivity(intent)
            finish()
        }
        volkswagen.setOnClickListener {
            val intent =  Intent(this@Brands, volkswagen::class.java)
            startActivity(intent)
            finish()
        }
        mitsubishi.setOnClickListener {
            val intent =  Intent(this@Brands, mitsubishi::class.java)
            startActivity(intent)
            finish()
        }
        ford.setOnClickListener {
            val intent =  Intent(this@Brands, ford::class.java)
            startActivity(intent)
            finish()
        }
        suzuki.setOnClickListener {
            val intent =  Intent(this@Brands, suzuki::class.java)
            startActivity(intent)
            finish()
        }
        peugeot.setOnClickListener {
            val intent =  Intent(this@Brands, peugeot::class.java)
            startActivity(intent)
            finish()
        }
        honda.setOnClickListener {
            val intent =  Intent(this@Brands, honda::class.java)
            startActivity(intent)
            finish()
        }
    }
}