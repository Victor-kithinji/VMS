package com.example.vms.ui.userNavigationBar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.databinding.ActivityUserNotificationBinding
import com.example.vms.ui.dataSource.TaskDataSource

class UserNotification : AppCompatActivity() {
    private lateinit var binding: ActivityUserNotificationBinding

    private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerTask.adapter = adapter
        updateList()

        insertListeners()
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener {
            startActivityForResult(Intent(this, AddTaskActivity::class.java), CREATE_NEW_TASK)
        }
        adapter.listenerEdit = {
            val intent = Intent(this, AddTaskActivity::class.java)
            intent.putExtra(AddTaskActivity.TASK_ID, it.id)
            startActivityForResult(intent, CREATE_NEW_TASK)
        }
        adapter.listenerDelete = {
            TaskDataSource.deleteTask(it)
            updateList()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_NEW_TASK && resultCode == Activity.RESULT_OK) updateList()

    }

    private fun updateList() {
        val list = TaskDataSource.getList()
        if (list.isEmpty()) {
            binding.emptyInclude.stateEmptyCs.visibility = View.VISIBLE
        } else {
            binding.emptyInclude.stateEmptyCs.visibility = View.GONE
        }
        adapter.submitList(list)
    }

    companion object {
        private const val CREATE_NEW_TASK = 1000
    }

}