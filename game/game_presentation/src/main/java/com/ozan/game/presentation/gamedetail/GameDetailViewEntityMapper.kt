package com.ozan.game.presentation.gamedetail

import com.ozan.core.mapper.Mapper
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.GameDetail

class GameDetailViewEntityMapper : Mapper<GameDetail, DisplayItem> {

    override suspend fun apply(item: GameDetail): DisplayItem {
        return GameDetailViewEntity(
            id = item.id,
            name = item.name,
            description = item.description,
            release = item.released,
            backgroundImage = item.backgroundImage,
            rating = item.rating
        )
    }
}