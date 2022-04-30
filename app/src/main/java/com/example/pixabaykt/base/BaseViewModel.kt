package com.example.pixabaykt.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaykt.domain.either.Either
import com.example.pixabaykt.presentation.ui.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> mutableUiStateFlow() = MutableStateFlow<UiState<T>>(UiState.Idle())

    protected fun <T, S> Flow<Either<String, T>>.gatherRequest(
        state: MutableStateFlow<UiState<S>>,
        mappedData: (data: T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UiState.Loading()
            this@gatherRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UiState.Error(it.value)
                    is Either.Right -> state.value = UiState.Success(mappedData(it.value))
                }
            }
        }
    }
}