package com.ozan.game.domain

import com.ozan.core.model.DataHolder
import io.reactivex.Single

interface GameRepository {

    fun fetchGames(request: GamesRequest): Single<DataHolder<GamesResponse>>

    fun getGameDetail(id: Int): Single<DataHolder<GameDetail>>
}