package com.example.retrofitmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DummyList(
    @SerializedName("userId")
    @Expose
    val details: List<Dummy>
)