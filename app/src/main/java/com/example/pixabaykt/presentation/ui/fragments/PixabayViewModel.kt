package com.example.pixabaykt.presentation.ui.fragments

import com.example.pixabaykt.domain.usecase.PixaBayUseCase
import com.example.pixabaykt.base.BaseViewModel
import com.example.pixabaykt.presentation.models.PixabayResponseUI
import com.example.pixabaykt.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val imageUseCase: PixaBayUseCase
) : BaseViewModel() {

    private val _searchQuery = mutableUiStateFlow<PixabayResponseUI>()
    val searchQuery = _searchQuery.asStateFlow()


    fun getImages(query: CharSequence) =
        imageUseCase(query).gatherRequest(_searchQuery) { it.toUI() }
}