package com.example.pixabaykt.data.remote

import com.example.pixabaykt.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("?key=$API_KEY")
    suspend fun fetchImages(): PixabayResponse
}