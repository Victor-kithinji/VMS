package com.example.vms.ui.spareParts.addcart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vms.databinding.SparePartRowBinding
import com.example.vms.ui.model.MyProductData


class SparePartsAdapter (private val onClickListener: OnClickListener) : androidx.recyclerview.widget.ListAdapter<MyProductData, SparePartsAdapter.MyViewHolder>(MyDiffUtil) {

    object MyDiffUtil : DiffUtil.ItemCallback<MyProductData>(){
        override fun areItemsTheSame(oldItem: MyProductData, newItem: MyProductData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MyProductData, newItem: MyProductData): Boolean {
            return oldItem.name == newItem.name
        }

    }


    inner class MyViewHolder(private val binding: SparePartRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sparePart: MyProductData) {
            binding.sparePartName.text = sparePart.name

            Glide.with(binding.imageSparePart).load(sparePart.imageId).into(binding.imageSparePart)

            binding.price.text = sparePart.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SparePartRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sparePart = getItem(position)
        holder.bind(sparePart)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(sparePart)
        }
    }

    // Handling OnclickListener on recyclerview holder
    class OnClickListener(val clickListener: (myProductData: MyProductData) -> Unit) {
        fun onClick(myProductData: MyProductData) = clickListener(myProductData)
    }



}