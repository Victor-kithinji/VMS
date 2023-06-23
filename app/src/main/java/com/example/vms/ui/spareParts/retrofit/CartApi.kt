package com.example.addcart.retrofit

import com.example.addcart.model.MyProductData
import retrofit2.Call

import retrofit2.http.GET

interface CartApi {
    @GET("spareparts")
    fun getSpareParts(): Call<ArrayList<MyProductData>>
}