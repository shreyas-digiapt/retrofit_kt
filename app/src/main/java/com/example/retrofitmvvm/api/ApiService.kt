package com.example.retrofitmvvm.api

import android.util.Log
import com.example.retrofitmvvm.Util.NetworkException
import com.example.retrofitmvvm.model.Dummy
import com.example.retrofitmvvm.model.NotiResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {


    @GET("posts")
   suspend fun getNaniDetails() : Response<List<Dummy>>



    companion object {
//        private const val BASE_URL = " https://jsonplaceholder.typicode.com/"
        operator fun invoke(
        ): ApiService {

//            val okHttp = OkHttpClient.Builder().addInterceptor(intecepter).build()
    Log.d("test123", "sad: sad")

            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
//                .client(okHttp)
                .build()
                .create(ApiService::class.java)
        }
    }
}