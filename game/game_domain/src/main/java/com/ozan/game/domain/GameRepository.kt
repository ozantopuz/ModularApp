package com.ozan.game.domain

import com.ozan.core.model.DataHolder

interface GameRepository {

    suspend fun fetchGames(page: Int): DataHolder<GamesResponse>

    suspend fun fetchGameDetail(id: Int): DataHolder<GameDetail>
}