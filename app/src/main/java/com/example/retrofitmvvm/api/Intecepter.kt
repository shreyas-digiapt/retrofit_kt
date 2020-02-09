package com.example.retrofitmvvm.api

import android.content.Context
import android.net.ConnectivityManager
import com.example.retrofitmvvm.Util.NetworkException
import com.example.retrofitmvvm.model.Content
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class Intecepter(context: Context): Interceptor  {

    private val appcontext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isIntenetAvalible()) {
            throw NetworkException("Please check yout internet connection")
        }
        return chain.proceed(chain.request())
    }


    private fun isIntenetAvalible(): Boolean {
        val isAvalible = appcontext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isAvalible.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }

}