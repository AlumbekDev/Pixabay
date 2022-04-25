package com.example.pixabaykt.ui.state

sealed class UiState<T> {
    class Idle<T> : UiState<T>()
    class Loading<T> : UiState<T>()
    class Error<T>(val data: String) : UiState<T>()
    class Success<T>(val data: T) : UiState<T>()

}