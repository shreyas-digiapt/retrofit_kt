package com.example.retrofitmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Notification(
    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("click_action")
    @Expose
    val clickAction: String? = null
)