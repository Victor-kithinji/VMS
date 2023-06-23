package com.example.vms.ui.spareParts.retrofit

import com.example.vms.ui.spareParts.retrofit.CartApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {
    private const val BASE_URL = "https://testapi.io/api/VictorKithinji/"
    private var myClient: MyRetrofit? = null
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Synchronized
    fun getInstance(): MyRetrofit {
        if (myClient == null) {
            myClient = MyRetrofit
        }
        return myClient!!
    }

    fun getMyApi(): CartApi {
        return retrofit.create(CartApi::class.java)
    }
}