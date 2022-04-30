package com.example.pixabeyapp.data.repository

import com.example.pixabaykt.domain.repositories.PixabayRepository
import com.example.pixabeyapp.data.remote.PixabayApi
import com.example.pixabeyapp.data.remote.toDomain
import com.example.pixabeyapp.data.repository.base.BaseRepository
import javax.inject.Inject

class PixabayRepositoryImpl @Inject constructor(
    private val pixabayApi: PixabayApi
) : BaseRepository(), PixabayRepository {

    override fun fetchImages(name: CharSequence) = sendRequest {
        pixabayApi.fetchImages(name).toDomain()
    }
}