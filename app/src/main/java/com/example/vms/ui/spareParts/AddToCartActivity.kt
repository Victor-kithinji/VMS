package com.example.vms.ui.spareParts

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.ui.spareParts.roomdatabase.Cart
import com.example.vms.ui.spareParts.roomdatabase.MyDatabase

class AddToCartActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    private val myDatabase: MyDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart)

        var imageId: ImageView = findViewById(R.id.productImage)
        val pname: TextView = findViewById(R.id.productName)
        val price: TextView = findViewById(R.id.productPrice)


        val sparePartsName = intent.getStringExtra("Name")
        val priceNew = intent.getStringExtra("Price")
        val imageNew = intent.getStringExtra("Image")

        pname.text = sparePartsName
        price.text = priceNew

//        val imageUri = intent.getParcelableExtra<Uri>("spare.imageId")
//        imageId.setImageURI(imageUri)

        imageView = findViewById(R.id.productImage)

        // Get the image URI from the intent
        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(imageUriString)

        // Load the image into the ImageView
        imageView.setImageURI(imageUri)

        val addToCart: Button = findViewById(R.id.addToCartBtn)

        addToCart.setOnClickListener {
            Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT).show()

            //(MyDatabase.cartDao())
            myDatabase?.cartDao()?.addToCart(cart = Cart("", "", "", ""))
        }

    }
}