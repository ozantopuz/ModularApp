package com.ozan.game.presentation.gamedetail

import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.GameDetail
import io.reactivex.functions.Function

class GameDetailViewEntityMapper : Function<GameDetail, DisplayItem> {

    override fun apply(gameDetail: GameDetail): DisplayItem {
        return GameDetailViewEntity(
            id = gameDetail.id,
            name = gameDetail.name,
            description = gameDetail.description,
            release = gameDetail.released,
            backgroundImage = gameDetail.backgroundImage,
            rating = gameDetail.rating
        )
    }
}