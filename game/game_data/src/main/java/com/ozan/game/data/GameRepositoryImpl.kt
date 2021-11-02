package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameRepository
import com.ozan.game.domain.GamesResponse
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gamesRemoteDataSource: DataSource.RetrieveRemoteDataSource<Int, GamesResponse>,
    private val gameDetailRemoteDataSource: DataSource.RetrieveRemoteDataSource<Int, GameDetail>
) : GameRepository {

    override suspend fun fetchGames(page: Int): DataHolder<GamesResponse> =
        gamesRemoteDataSource.getResult(page)

    override suspend fun fetchGameDetail(id: Int): DataHolder<GameDetail> =
        gameDetailRemoteDataSource.getResult(id)
}