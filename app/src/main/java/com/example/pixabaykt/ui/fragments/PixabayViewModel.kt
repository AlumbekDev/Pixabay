package com.example.pixabaykt.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaykt.data.local.entity.Pixabay
import com.example.pixabaykt.data.local.repository.PixabayRepository
import com.example.pixabaykt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val pixabayRepository: PixabayRepository
) : ViewModel() {

    private val _searchQuery = MutableLiveData<Resource<List<Pixabay>>>()
    val searchQuery: LiveData<Resource<List<Pixabay>>> = _searchQuery

    fun getImages(query: CharSequence) = viewModelScope.launch {
        pixabayRepository.fetchImages(query).collect {
            _searchQuery
        }
    }

    fun fetchImagesFromDB(query: String) = viewModelScope.launch {
//        pixabayRepository.fetchImagesFromDB(query).collect {
//            _searchQuery.value = it
//        }
    }
}