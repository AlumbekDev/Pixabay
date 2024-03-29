package com.example.pixabeyapp.data.remote.dto

import com.example.pixabaykt.domain.models.PixabayModel

data class PixabayDto(
    val id: Int,
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    val userId: Int,
    val userImageURL: String,
    val views: Int,
    val webformatHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int
)

fun PixabayDto.toDomain() = PixabayModel(
    id,collections, comments, downloads, imageHeight, imageSize, imageWidth, largeImageURL, likes, pageURL, previewHeight, previewURL, previewWidth, tags, type, user, userId, userImageURL, views, webformatHeight, webformatURL, webformatWidth
)
