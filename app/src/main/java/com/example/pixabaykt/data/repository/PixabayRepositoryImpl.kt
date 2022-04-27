package com.example.pixabaykt.data.repository

import com.example.pixabaykt.base.BaseRepository
import com.example.pixabaykt.data.remote.PixabayApi
import com.example.pixabaykt.data.remote.toDomain
import com.example.pixabaykt.domain.repositories.PixabayRepository
import javax.inject.Inject

class PixabayRepositoryImpl @Inject constructor(
    private val pixabayApi: PixabayApi
) : BaseRepository(), PixabayRepository {

    override fun fetchImages(name: CharSequence) = sendRequest {
        pixabayApi.fetchImages(name).toDomain()
    }
}