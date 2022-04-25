package com.example.pixabaykt.data.local.repository

import com.example.pixabaykt.base.BaseRepository
import com.example.pixabaykt.data.local.dao.PixabayDao
import com.example.pixabaykt.data.remote.PixabayApi
import javax.inject.Inject

//class PixabayRepository @Inject constructor(
//    private val pixabayApi: PixabayApi,
//    private val pixabayDao: PixabayDao
//) : SafeApiRequest() {

//    fun fetchImages(name: CharSequence) = flow {
//        emit(Resource.Loading())
//        try {
//            pixabayDao.saveImage(pixabayApi.fetchImages(name).hits)
//            emit(Resource.Success(data = pixabayApi.fetchImages(name).hits))
//        } catch (e: HttpException) {
//            emit(
//                Resource.Error(
//                    message = "oops something went wrong", data = null,
//                )
//            )
//        } catch (e: IOException) {
//            emit(
//                Resource.Error(
//                    "Internet error", data = null
//                )
//            )
//        }
//    }

//    fun fetchImagesFromDB(query: String) = flow {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(pixabayDao.fetchImages(query)))
//        } catch (e: HttpException) {
//            emit(
//                Resource.Error(
//                    message = "oops something went wrong", data = null,
//                )
//            )
//        } catch (e: IOException) {
//            emit(
//                Resource.Error(
//                    "Internet error", data = null
//                )
//            )
//        }
//    }
//}

    class PixabayRepository @Inject constructor(
        private val pixabayApi: PixabayApi

    ) : BaseRepository() {
        fun fetchImages(query: CharSequence) = sendRequest {
            pixabayApi.fetchImages()
        }

    }