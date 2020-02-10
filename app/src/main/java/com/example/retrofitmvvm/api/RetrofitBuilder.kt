package com.example.retrofitmvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder().baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val service = retrofit.create(ApiService::class.java)
}