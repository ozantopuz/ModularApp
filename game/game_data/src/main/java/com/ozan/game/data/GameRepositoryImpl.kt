package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.error.DefaultErrorFactory
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameRepository
import com.ozan.game.domain.GamesResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gamesRemoteDataSource: DataSource.RetrieveRemoteDataSource<Int, GamesResponse>,
    private val gameDetailRemoteDataSource: DataSource.RetrieveRemoteDataSource<Int, GameDetail>
) : GameRepository {
    override fun fetchGames(page: Int): Single<DataHolder<GamesResponse>> =
        gamesRemoteDataSource
            .getResult(page)
            .map { it }
            .onErrorReturn {
                DataHolder.Fail(
                    DefaultErrorFactory().createApiError(1,"Unexpected api error!")
                )
            }
            .subscribeOn(Schedulers.io())

    override fun fetchGameDetail(id: Int): Single<DataHolder<GameDetail>> =
        gameDetailRemoteDataSource
            .getResult(id)
            .map { it }
            .onErrorReturn {
                DataHolder.Fail(
                    DefaultErrorFactory().createApiError(1,"Unexpected api error!")
                )
            }
            .subscribeOn(Schedulers.io())

}