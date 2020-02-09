package com.example.retrofitmvvm.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NotiResponse(
    @SerializedName("to")
    @Expose
    val to: String,
    @SerializedName("notification")
    @Expose
    val notification: Notification,
    @SerializedName("data")
    @Expose
    val data: NotiData
)