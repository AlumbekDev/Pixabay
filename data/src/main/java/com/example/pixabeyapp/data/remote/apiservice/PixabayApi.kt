package com.example.pixabeyapp.data.remote.apiservice

import com.example.pixabeyapp.data.remote.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("?key=$API_KEY")
    suspend fun fetchImages(
        @Query("q") query: CharSequence?
    ): PixabayResponse

    companion object {
        const val API_KEY = "25973111-24329f9f2d4e8aac3285bdcee"
    }
}
