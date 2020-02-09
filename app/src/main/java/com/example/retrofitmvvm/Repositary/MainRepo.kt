package com.example.retrofitmvvm.Repositary

import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.api.SafeApiRequest
import com.example.retrofitmvvm.model.Dummy

class MainRepo(private val apiService: ApiService) : SafeApiRequest() {

    suspend fun getNotiDetails(): List<Dummy> {
        return apiRequest {
            apiService.getNaniDetails()
        }
    }
}