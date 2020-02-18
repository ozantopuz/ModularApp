package com.ozan.game.presentation

import com.ozan.core.presentation.base.BaseActivity
import com.ozan.core.presentation.navigation.UiNavigation

class GamesActivity : BaseActivity() {

    override val uiNavigation: UiNavigation = UiNavigation.ROOT

    override fun getLayoutRes(): Int = R.layout.activity_games

}