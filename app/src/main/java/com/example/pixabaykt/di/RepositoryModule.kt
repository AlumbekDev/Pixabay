package com.example.pixabaykt.di

import com.example.pixabaykt.data.repository.PixabayRepositoryImpl
import com.example.pixabaykt.domain.repositories.PixabayRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPixabayRepository(pixabayRepositoryImpl: PixabayRepositoryImpl): PixabayRepository
}