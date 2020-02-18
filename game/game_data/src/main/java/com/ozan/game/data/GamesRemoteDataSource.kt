package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GamesResponse
import io.reactivex.Single
import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<Int, GamesResponse> {

    override fun getResult(page: Int): Single<DataHolder<GamesResponse>> =
        gameServices.fetchGames(page = page)

            .map {
                return@map DataHolder.Success(
                    GamesResponse(
                        count = it.count,
                        next = it.next,
                        previous = it.previous,
                        results = it.results
                    )
                )
            }

}