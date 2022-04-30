package com.example.pixabaykt.presentation.ui.models

import com.example.pixabaykt.domain.models.PixabayResponseModel


data class PixabayResponseUI(
    val hits: List<PixabayUI>
)

fun PixabayResponseModel.toUI() = PixabayResponseUI(
    hits.map { it.toUI() }
)