package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GamesResponse
import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<Int, GamesResponse> {

    override suspend fun getResult(request: Int): DataHolder<GamesResponse> {
        val response = gameServices.fetchGames(page = request)
        return DataHolder.Success(
            GamesResponse(
                count = response.count,
                next = response.next,
                previous = response.previous,
                results = response.results
            )
        )
    }
}