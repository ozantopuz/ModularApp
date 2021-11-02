package com.ozan.core.entity

import com.ozan.game.domain.GameDetail

object GameDetailFactory {

    fun getGameDetail() = GameDetail(
        id = 3498,
        name = "Grand Theft Auto V",
        description = "<p>Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate) and the amount is rising with every update. <br /> Simultaneous storytelling from three unique perspectives: <br /> Follow Michael, ex-criminal living his life of leisure away from the past, Franklin, a kid that seeks the better future, and Trevor, the exact past Michael is trying to run away from. <br /> GTA Online will provide a lot of additional challenge even for the experienced players, coming fresh from the story mode. Now you will have other players around that can help you just as likely as ruin your mission. Every GTA mechanic up to date can be experienced by players through the unique customizable character, and community content paired with the leveling system tends to keep everyone busy and engaged.</p>",
        released = "2013-09-17",
        backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
        backgroundImageAdditional = "https://media.rawg.io/media/screenshots/5f5/5f5a38a222252d996b18962806eed707.jpg",
        website = "http://www.rockstargames.com/V/",
        rating = 4.48,
        ratingsCount = 5145,
        reviewsCount = 59
    )
}
