package com.example.vms.ui.spareParts.retrofit

import com.example.vms.ui.model.MyProductData
import retrofit2.Call

import retrofit2.http.GET

interface CartApi {
    @GET("spareparts")
    fun getSpareParts(): Call<ArrayList<MyProductData>>
}