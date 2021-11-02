package com.ozan.core.entity

import com.ozan.game.domain.Game

object GameFactory {

    fun getGame() = Game(
        id = 3498,
        name = "Grand Theft Auto V",
        released = "2013-09-17",
        backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
        rating = 4.48
    )
}
