package com.ozan.core.entity

import com.ozan.core.data.api.PagedApiResponse
import com.ozan.game.domain.Game

object PagedApiResponseFactory {

    fun getPagedApiResponse() = PagedApiResponse<List<Game>>(
        count = 635954,
        next = "https://api.rawg.io/api/games?key=4dfe2a4b8bb644f1bc2033ffedb35d61&page=2&page_size=20",
        previous = null,
        results = arrayListOf(GameFactory.getGame())
    )
}
