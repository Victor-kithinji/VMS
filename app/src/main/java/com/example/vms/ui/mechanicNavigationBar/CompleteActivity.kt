package com.example.vms.ui.mechanicNavigationBar

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class CompleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        val btnGoBack:Button =findViewById(R.id.btnGoBack)
        btnGoBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}