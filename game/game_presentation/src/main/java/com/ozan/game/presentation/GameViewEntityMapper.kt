package com.ozan.game.presentation

import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.Game
import io.reactivex.functions.Function

class GameViewEntityMapper : Function<Game, DisplayItem> {

    override fun apply(t:Game): DisplayItem{
        return GameViewEntity(
            id = t.id,
            name = t.name,
            released = t.released,
            backgroundImage = t.backgroundImage,
            rating = t.rating
        )
    }

}
