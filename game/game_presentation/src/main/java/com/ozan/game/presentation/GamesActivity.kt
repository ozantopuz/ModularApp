package com.ozan.game.presentation

import android.os.Bundle
import com.ozan.core.navigation.controller.DefaultNavigationController
import com.ozan.core.presentation.base.BaseActivity
import com.ozan.core.presentation.navigation.UiNavigation
import java.lang.ref.WeakReference

class GamesActivity : BaseActivity() {

    private lateinit var navigationController: DefaultNavigationController

    override val uiNavigation: UiNavigation = UiNavigation.ROOT

    override fun getLayoutRes(): Int = R.layout.activity_games

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(this))

        navigationController.navigateToDashboardFragment(R.id.frameLayout)
    }
}