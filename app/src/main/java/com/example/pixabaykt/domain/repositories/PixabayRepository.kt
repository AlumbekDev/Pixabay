package com.example.pixabaykt.domain.repositories

import com.example.pixabaykt.domain.either.Either
import com.example.pixabaykt.domain.models.PixabayResponseModel
import kotlinx.coroutines.flow.Flow

interface PixabayRepository {
    fun fetchImages(name: CharSequence): Flow<Either<String, PixabayResponseModel>>

}