package com.example.vms.ui.spareParts

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.vms.R
import com.example.vms.ui.spareParts.addcart.CartAdapter
import com.example.vms.ui.spareParts.roomdatabase.Cart
import com.example.vms.ui.spareParts.roomdatabase.MyDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SpareCartActivity : AppCompatActivity() {

    private lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_spare_cart)


        val cartsRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)

        // implementation to view all available carts

        db = Room.databaseBuilder(applicationContext, MyDatabase::class.java,"cart-db")
            .addMigrations()
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        lifecycleScope.launch {
            val carts: List<Cart> = db.cartDao().getCarts().first()
            // Retrieve carts asynchronously

            if(carts.isEmpty()) {
                Toast.makeText(this@SpareCartActivity.applicationContext,"No carts available",Toast.LENGTH_SHORT).show()
            }
            else {
                val adapter = CartAdapter(carts)
                cartsRecyclerView.adapter = adapter
            }

        }

        /**
        val carts: List<Cart> = db.cartDao().getCarts()

        //val cartDao = db.cartDao()
        //val cartItems = cartDao.getCarts()
        val cartAdapter = CartAdapter(carts)

        cartsRecyclerView.adapter = cartAdapter

       val checkOutButtonToPay = findViewById<Button>(R.id.checkOutBtn)

        checkOutButtonToPay.setOnClickListener {
            // TODO Payment
        }
        **/


    }
}