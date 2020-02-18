package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.core.model.DataHolder
import com.ozan.game.domain.GamesRequest
import com.ozan.game.domain.GamesResponse
import io.reactivex.Single
import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(
    private val gameServices: GameServices
) : DataSource.RetrieveRemoteDataSource<GamesRequest, GamesResponse> {

    override fun getResult(request: GamesRequest): Single<DataHolder<GamesResponse>> =
        gameServices.fetchGames(page = request.page)

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