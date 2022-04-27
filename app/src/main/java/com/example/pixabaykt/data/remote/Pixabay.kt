package com.example.pixabaykt.data.remote

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pixabaykt.domain.models.PixabayModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pixabay_table")
data class Pixabay(
    @PrimaryKey
    @SerializedName("id")
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
): Parcelable
fun Pixabay.toDomain() = PixabayModel(
    id,collections, comments, downloads, imageHeight, imageSize, imageWidth, largeImageURL, likes, pageURL, previewHeight, previewURL, previewWidth, tags, type, user, userId, userImageURL, views, webformatHeight, webformatURL, webformatWidth
)
