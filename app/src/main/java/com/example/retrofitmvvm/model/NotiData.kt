package com.example.retrofitmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NotiData(
    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("content")
    @Expose
    val content:List<Content>
)