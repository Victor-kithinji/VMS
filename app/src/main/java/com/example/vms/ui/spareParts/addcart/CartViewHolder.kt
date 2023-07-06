package com.example.vms.ui.spareParts.addcart

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vms.R

class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Bind views from the item layout here
    val itemNameTextView: TextView = itemView.findViewById(R.id.sparePartName)
    val priceTextView: TextView = itemView.findViewById(R.id.price)
}