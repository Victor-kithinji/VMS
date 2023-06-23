package com.example.vms.ui.spareParts

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.addcart.roomdatabase.MyDatabase
import com.example.vms.R
import com.example.vms.ui.spareParts.roomdatabase.Cart

class AddToCartActivity : AppCompatActivity() {


    private val myDatabase: MyDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart)

        val imageId: ImageView = findViewById(R.id.productImage)
        val pname: TextView = findViewById(R.id.productName)
        val price: TextView = findViewById(R.id.productPrice)


        val nameNew = intent.getStringExtra("Name")
        val priceNew = intent.getStringExtra("Price")
        val imageNew = intent.getStringExtra("Image")

        pname.text = priceNew
        price.text = priceNew


        val addToCart: Button = findViewById(R.id.addToCartBtn)

        addToCart.setOnClickListener {
            Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT).show()

            //(MyDatabase.cartDao())
            myDatabase?.cartDao()?.addToCart(cart = Cart("", "", "", ""))
        }

    }
}