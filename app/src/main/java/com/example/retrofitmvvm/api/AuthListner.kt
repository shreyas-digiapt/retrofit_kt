package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.Dummy

interface AuthListner {
    fun onStarted()
    fun onSuccess(data: List<Dummy>)
    fun onFailure(message: String?)
}