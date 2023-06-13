package com.example.vms.ui.spareParts.toyota

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R

class Toyota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toyota)

        val toyotaAlternators: Button =findViewById(R.id.toyota_alternatorsButton)
        val toyotaFilter: Button =findViewById(R.id.toyota_filterButton)
        val toyotaGasket: Button =findViewById(R.id.toyota_gasketButton)
        val toyotaLamps: Button =findViewById(R.id.toyota_lampsButton)
        val toyotaToolKit: Button =findViewById(R.id.toyota_tool_kitButton)
        val toyotaSideMirrors: Button =findViewById(R.id.toyota_side_mirrorsButton)
        val toyotaPiston: Button =findViewById(R.id.toyota_pistonButton)


    }
}