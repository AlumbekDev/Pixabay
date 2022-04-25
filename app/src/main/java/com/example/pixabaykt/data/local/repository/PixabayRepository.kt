package com.example.pixabaykt.data.local.repository

import com.example.pixabaykt.base.BaseRepository
import com.example.pixabaykt.data.local.dao.PixabayDao
import com.example.pixabaykt.data.remote.PixabayApi
import javax.inject.Inject

class PixabayRepository @Inject constructor(
    private val pixabayApi: PixabayApi,
    private val pixabayDao: PixabayDao
) : BaseRepository() {

    fun fetchImages(name: CharSequence) = sendRequest {
        pixabayApi.fetchImages(name)
    }
}


