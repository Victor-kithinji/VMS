package com.example.vms.ui.spareParts.addcart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vms.R
import com.example.vms.ui.spareParts.roomdatabase.Cart


/**
 * List all available cart from room db
 */

class CartAdapter(private val cartItems: List<Cart>) : RecyclerView.Adapter<CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_cart, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        // Bind data to views in the ViewHolder
        holder.itemNameTextView.text = cartItem.name
        holder.priceTextView.text = cartItem.price
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}