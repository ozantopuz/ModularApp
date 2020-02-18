package com.ozan.game.presentation.gamedetail

import com.ozan.core.presentation.entity.ViewEntity
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.presentation.GamePresentationConstants

class GameDetailViewEntity(
    val id: Int?,
    val name: String?,
    val description: String?,
    val release: String?,
    val backgroundImage: String?,
    val rating: Double?
) : ViewEntity, DisplayItem {

    override fun type(): Int = GamePresentationConstants.TYPES.GAME_DETAIL
}