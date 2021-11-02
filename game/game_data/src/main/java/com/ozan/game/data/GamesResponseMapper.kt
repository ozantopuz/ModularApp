package com.ozan.game.data

import com.ozan.core.data.api.PagedApiResponse
import com.ozan.core.mapper.Mapper
import com.ozan.game.domain.Game
import com.ozan.game.domain.GamesResponse

class GamesResponseMapper : Mapper<PagedApiResponse<List<Game>>, GamesResponse> {

    override suspend fun apply(item: PagedApiResponse<List<Game>>): GamesResponse {
        return GamesResponse(
            count = item.count,
            next = item.next,
            previous = item.previous,
            results = item.results
        )
    }

}
