package com.example.retrofitmvvm.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Content(
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("url")
    @Expose
     val url: String
)