package com.example.vms.ui.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class LocationInfo(
    var latitude: Double? = 0.0,
    var longitude: Double? = 0.0
)