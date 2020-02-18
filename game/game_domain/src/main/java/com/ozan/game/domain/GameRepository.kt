package com.ozan.game.domain

import com.ozan.core.model.DataHolder
import io.reactivex.Single

interface GameRepository {

    fun fetchGames(page: Int): Single<DataHolder<GamesResponse>>

    fun fetchGameDetail(id: Int): Single<DataHolder<GameDetail>>
}