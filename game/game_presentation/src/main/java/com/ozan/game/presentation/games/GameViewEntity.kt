package com.ozan.game.presentation.games

import com.ozan.core.presentation.entity.ViewEntity
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.presentation.GamePresentationConstants

class GameViewEntity(
    val id: Int?,
    val name: String?,
    val released: String?,
    val backgroundImage: String?,
    val rating: Double?
) : ViewEntity, DisplayItem {

    override fun type(): Int = GamePresentationConstants.TYPES.GAME
}
