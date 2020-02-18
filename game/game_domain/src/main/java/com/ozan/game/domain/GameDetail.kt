package com.ozan.game.domain

import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("released") val released: String?,
    @SerializedName("background_image") val backgroundImage: String?,
    @SerializedName("background_image_additional") val backgroundImageAdditional: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("ratings_count") val ratingsCount: Int?,
    @SerializedName("reviews_count") val reviewsCount: Int?
)
