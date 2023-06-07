package com.example.vms.ui.userNavigationBar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vms.R
import com.example.vms.databinding.ItemTaskBinding

class TaskListAdapter : ListAdapter<com.example.vms.ui.model.Task, TaskListAdapter.TaskViewHolder>(DiffCallback()) {

    var listenerEdit: (com.example.vms.ui.model.Task) -> Unit = {}
    var listenerDelete: (com.example.vms.ui.model.Task) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TaskViewHolder(
        private val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: com.example.vms.ui.model.Task) {
            binding.tvTitle.text = item.title
            binding.tvDate.text = "${item.date} ${item.hour}"
            binding.ivMore.setOnClickListener {
                showPopup(item)
            }
        }

        private fun showPopup(item: com.example.vms.ui.model.Task) {
            val ivMore = binding.ivMore
            val popupMenu = PopupMenu(ivMore.context, ivMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_edit -> listenerEdit(item)
                    R.id.action_delete -> listenerDelete(item)
                }
                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<com.example.vms.ui.model.Task>() {
    override fun areItemsTheSame(oldItem: com.example.vms.ui.model.Task, newItem: com.example.vms.ui.model.Task) = oldItem == newItem
    override fun areContentsTheSame(oldItem: com.example.vms.ui.model.Task, newItem: com.example.vms.ui.model.Task) = oldItem.id == newItem.id
}