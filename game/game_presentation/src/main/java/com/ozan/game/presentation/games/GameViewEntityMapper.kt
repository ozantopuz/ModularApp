package com.ozan.game.presentation.games

import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.Game
import io.reactivex.functions.Function

class GameViewEntityMapper : Function<Game, DisplayItem> {

    override fun apply(game : Game): DisplayItem{
        return GameViewEntity(
            id = game.id,
            name = game.name,
            released = game.released,
            backgroundImage = game.backgroundImage,
            rating = game.rating
        )
    }

}
