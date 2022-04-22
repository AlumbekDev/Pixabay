package com.example.pixabaykt.di

import android.content.Context
import androidx.room.Room
import com.example.pixabaykt.data.local.dao.PixabayDao
import com.example.pixabaykt.data.local.db.PixabayDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDb(@ApplicationContext context: Context): PixabayDb {
        return Room.databaseBuilder(
            context, PixabayDb::class.java,
            "pixabay_db").
        build()
    }

    @Provides
    @Singleton
    fun providesDao(pixabayDb: PixabayDb): PixabayDao {
        return pixabayDb.pixabayDao()
    }

}