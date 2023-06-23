package com.example.vms.ui.mechanicNavigationBar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vms.R
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory

class MechanicRate : AppCompatActivity() {
    private val ACTIVITY_CALLBACK = 1
    private var reviewInfo: ReviewInfo? = null
    private lateinit var reviewManager: ReviewManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_rate)
        reviewManager = ReviewManagerFactory.create(this)

        //Request a ReviewInfo object ahead of time (Pre-cache)
        val requestFlow = reviewManager.requestReviewFlow()
        requestFlow.addOnCompleteListener { request ->
            reviewInfo = if (request.isSuccessful) {
                //Received ReviewInfo object
                request.result
            } else {
                //Problem in receiving object
                null
            }
        }

        val btnSurprise: Button = findViewById(R.id.btnSurprise)
        btnSurprise.setOnClickListener {
            startActivityForResult(
                Intent(this, CompleteActivity::class.java),
                ACTIVITY_CALLBACK
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ACTIVITY_CALLBACK && resultCode == Activity.RESULT_OK) {
            Handler().postDelayed({
                reviewInfo?.let {
                    val flow = reviewManager.launchReviewFlow(this@MechanicRate, it)
                    flow.addOnSuccessListener {
                        //Showing toast is only for testing purpose, this shouldn't be implemented
                        //in production app.
                        Toast.makeText(
                            this@MechanicRate,
                            "Thanks for the feedback!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    flow.addOnFailureListener {
                        //Showing toast is only for testing purpose, this shouldn't be implemented
                        //in production app.
                        Toast.makeText(this@MechanicRate, "${it.message}", Toast.LENGTH_LONG).show()
                    }
                    flow.addOnCompleteListener {
                        //Showing toast is only for testing purpose, this shouldn't be implemented
                        //in production app.
                        Toast.makeText(this@MechanicRate, "Completed!", Toast.LENGTH_LONG).show()
                    }
                }
            }, 3000)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}


