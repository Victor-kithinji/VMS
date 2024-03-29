package com.example.vms.ui.spareParts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.example.vms.databinding.ActivitySparePartsBinding
import com.example.vms.ui.dashboard.UserDashboard
import com.example.vms.ui.model.MyProductData
import com.example.vms.ui.spareParts.addcart.SparePartsAdapter
import com.example.vms.ui.spareParts.retrofit.MyRetrofit
import retrofit2.Call
import retrofit2.Response

class SpareParts : AppCompatActivity() {
    private lateinit var binding: ActivitySparePartsBinding
//    val adapter by lazy { SparePartsAdapter()}
    private lateinit var adapter: SparePartsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySparePartsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.iVallCarts.setOnClickListener {
            startActivity(Intent(this@SpareParts,SpareCartActivity::class.java))
            finish()
        }



        adapter = SparePartsAdapter(SparePartsAdapter.OnClickListener { spare->
            Log.i(TAG,spare.name)


            val intent = Intent(this,AddToCartActivity::class.java).also {

                val name = findViewById<TextView?>(R.id.productName)
                val price = findViewById<TextView?>(R.id.productPrice)
                val image= findViewById<ImageView?>(R.id.imageSparePart)


                it.putExtra("Name",spare.name)
//                Uri.parse(spare.imageId)

//
                it.putExtra("imageUri", image.toString())
                startActivity(intent)
                it.putExtra("Price",spare.price)
                startActivity(it);
            }
        })

        MyRetrofit.getMyApi().getSpareParts().enqueue(object : retrofit2.Callback<ArrayList<MyProductData>>{
            override fun onResponse(
                call: retrofit2.Call<ArrayList<MyProductData>>,
                response: Response<ArrayList<MyProductData>>
            ) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                    binding.recyclerView.adapter = adapter
                }

            }

            override fun onFailure(call: Call<ArrayList<MyProductData>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "No available spare parts",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    override fun onBackPressed() {
        val intent = Intent(this, UserDashboard::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val TAG = "SpareParts"
    }
}
