package com.example.pixabaykt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PixabayApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}