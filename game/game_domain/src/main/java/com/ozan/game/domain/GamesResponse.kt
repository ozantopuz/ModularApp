package com.ozan.game.domain

import com.google.gson.annotations.SerializedName

class GamesResponse (
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<Game>?
)