package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GameDetail
import javax.inject.Inject

class GameDetailRemoteDataSource @Inject constructor(
    private val gameService: GameService
) : DataSource.RetrieveRemoteDataSource<Int, GameDetail> {

    override suspend fun getResult(request: Int): DataHolder<GameDetail> {
        val response = gameService.fetchGameDetail(request)
        return DataHolder.Success(response)
    }
}