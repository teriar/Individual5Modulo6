package com.example.cl.individual5modulo6.data.remote

import com.google.gson.annotations.SerializedName

data class Terreno(
    val id: String,
    @SerializedName("price") val price: Long,
    @SerializedName("type") val type: String,
    @SerializedName("img_src") val img: String
)
