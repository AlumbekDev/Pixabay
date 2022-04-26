package com.example.pixabaykt.data.remote

import com.example.pixabaykt.domain.models.PixabayResponseModel
import com.google.gson.annotations.SerializedName

data class PixabayResponse(
    @SerializedName("hits")
    val hits: List<Pixabay>
)
fun PixabayResponse.toDomain() = PixabayResponseModel(hits.map { it.toDomain() })