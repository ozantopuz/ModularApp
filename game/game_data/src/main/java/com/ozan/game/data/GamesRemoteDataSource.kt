package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GamesResponse
import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(
    private val gameService: GameService,
    private val mapper: GamesResponseMapper
) : DataSource.RetrieveRemoteDataSource<Int, GamesResponse> {

    override suspend fun getResult(request: Int): DataHolder<GamesResponse> {
        val response = gameService.fetchGames(page = request)
        return DataHolder.Success(mapper.apply(response))
    }
}