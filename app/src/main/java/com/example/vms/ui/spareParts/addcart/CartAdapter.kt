package com.example.vms.ui.spareParts.addcart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vms.databinding.ActivityCartBinding
import com.example.vms.ui.spareParts.roomdatabase.Cart

class CartAdapter: androidx.recyclerview.widget.ListAdapter<Cart, CartAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil: DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.name == newItem.name
        }

    }

    inner class MyViewHolder(private val binding: ActivityCartBinding)
        : RecyclerView.ViewHolder(binding.root) //Returns outermost View in the associated layout.
    {
        @SuppressLint("SetTextI18n")
        fun bind(cart: Cart) {
            binding.price.text = cart.price
            binding.sparePartName.text = cart.name
            Glide.with(binding.imageSparePart).load(cart.imageId).into(binding.imageSparePart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ActivityCartBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cart = getItem(position)
        holder.bind(cart)



        /**
        holder.itemView.setOnClickListener {

        val alertDialog = AlertDialog.Builder(it.context)
        .setTitle("Place Bid")
        .setMessage("Do you want to bid this?")
        .setCancelable(true)
        .setNegativeButton("No") {dialog: DialogInterface, which:Int ->
        dialog.dismiss()
        }
        .setPositiveButton("Yes") { dialog: DialogInterface, which:Int ->
        Navigation.findNavController(view = View(it.context))
        .navigate(R.id.action_dashboardFragment2_to_itemBiddingDetailFragment2)
        }

        alertDialog.create()
        alertDialog.show()
        }
         */

    }
}