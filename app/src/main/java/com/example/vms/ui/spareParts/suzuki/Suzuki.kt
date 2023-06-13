
package com.example.vms.ui.spareParts.suzuki

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Suzuki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suzuki)

        val  suzukiCondenser: Button =findViewById(R.id.suzuki_condesorButton)
        val  suzukiCatalyticConverter: Button =findViewById(R.id.suzukicatalyticconveterButton)
        val  suzukiAlternators: Button =findViewById(R.id.suzukialtenatorsButton)


    }
}