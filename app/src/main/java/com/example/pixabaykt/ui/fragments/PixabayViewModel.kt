package com.example.pixabaykt.ui.fragments

import com.example.pixabaykt.base.BaseViewModel
import com.example.pixabaykt.data.local.entity.Pixabay
import com.example.pixabaykt.data.local.repository.PixabayRepository
import com.example.pixabaykt.data.remote.PixabayResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val pixabayRepository: PixabayRepository
) : BaseViewModel() {

    private val _searchQuery = mutableUiStateFlow<List<Pixabay>>()
    val searchQuery = _searchQuery.asStateFlow()


    fun getImages(query: CharSequence) =
        pixabayRepository.fetchImages(query).gatherRequest(_searchQuery)
}


