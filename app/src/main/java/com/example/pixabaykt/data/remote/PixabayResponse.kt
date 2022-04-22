package com.example.pixabaykt.data.remote

import com.example.pixabaykt.data.local.entity.Pixabay
import com.google.gson.annotations.SerializedName

data class PixabayResponse(
    @SerializedName("hits")
    val hits: List<Pixabay>
)