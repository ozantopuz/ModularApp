package com.ozan.game.presentation.games

import com.ozan.core.mapper.Mapper
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.Game

class GameViewEntityMapper : Mapper<Game, DisplayItem> {

    override suspend fun apply(item : Game): DisplayItem{
        return GameViewEntity(
            id = item.id,
            name = item.name,
            released = item.released,
            backgroundImage = item.backgroundImage,
            rating = item.rating
        )
    }

}
