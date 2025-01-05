package com.oscar.instagramclon.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}