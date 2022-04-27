package com.example.pixabaykt.domain.usecase

import com.example.pixabaykt.domain.repositories.PixabayRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PixaBayUseCase @Inject constructor(
    private val pixabayRepository: PixabayRepository
) {
    operator fun invoke(name: CharSequence) = pixabayRepository.fetchImages(name)

}