package com.example.pixabaykt.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaykt.common.either.Either
import com.example.pixabaykt.ui.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> mutableUiStateFlow() = MutableStateFlow<UiState<T>>(UiState.Idle())

    protected fun <T> Flow<Either<String, T>>.gatherRequest(
        state: MutableStateFlow<UiState<T>>,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UiState.Loading()
        }
    }
}