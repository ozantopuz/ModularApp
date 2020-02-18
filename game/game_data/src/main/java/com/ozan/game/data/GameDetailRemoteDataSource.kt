package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GameDetail
import io.reactivex.Single
import javax.inject.Inject

class GameDetailRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<Int, GameDetail> {

    override fun getResult(request: Int): Single<DataHolder<GameDetail>> =
        gameServices.fetchGameDetail(request)

            .map { return@map DataHolder.Success(it) }
}