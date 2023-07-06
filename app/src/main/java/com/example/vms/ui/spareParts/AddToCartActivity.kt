package com.example.vms.ui.spareParts

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.vms.R
import com.example.vms.ui.spareParts.roomdatabase.Cart
import com.example.vms.ui.spareParts.roomdatabase.MyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddToCartActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView


    private lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart)

        db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "cart-db")
            .build()

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

        // Get the image URI from the intent
//        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(intent.getStringExtra("imageUri"))


        // Load the image into the ImageView
       // imageId.setImageURI(imageUri)

        val addToCart: Button = findViewById(R.id.addToCartBtn)

        addToCart.setOnClickListener {
            Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT).show()

            val cart = sparePartsName?.let { it1 ->
                priceNew?.let { price ->
                    Cart("50", it1,imageUri.toString(),price)
                }
            }

            if (cart != null) {
                val cartDao = db.cartDao()


                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        cartDao.addToCart(cart)
                    }
                    Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT).show()
                }
                /**
                val addToCartSuccessful = cartDao.addToCart(cart)
                if (addToCartSuccessful.equals(true)) {
                    Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Error occurred", Toast.LENGTH_SHORT).show()
                }
                */
            }
        }
    }
}
