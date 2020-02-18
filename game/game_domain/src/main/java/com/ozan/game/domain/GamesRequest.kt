package com.ozan.game.domain

import com.google.gson.annotations.SerializedName

class GamesRequest (
    @SerializedName("page") val page: Int?
)