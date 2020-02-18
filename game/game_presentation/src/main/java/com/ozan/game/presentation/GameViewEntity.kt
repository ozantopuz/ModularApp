package com.ozan.game.presentation

import com.ozan.core.presentation.entity.ViewEntity
import com.ozan.core.presentation.recyclerview.DisplayItem

class GameViewEntity(
    val id: Int?,
    val name: String?,
    val released: String?,
    val backgroundImage: String?,
    val rating: Double?
) : ViewEntity, DisplayItem {

    override fun type(): Int =
        GamePresentationConstants.TYPES.GAME
}
