package com.ozan.game.presentation

import android.os.Bundle
import com.ozan.core.navigation.controller.DefaultNavigationController
import com.ozan.core.presentation.base.BaseActivity
import com.ozan.core.presentation.navigation.UiNavigation
import com.ozan.game.presentation.gamedetail.GameDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class GamesActivity : BaseActivity() {

    private lateinit var navigationController: DefaultNavigationController

    override val uiNavigation: UiNavigation = UiNavigation.ROOT

    override fun getLayoutRes(): Int = R.layout.activity_games

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(this))

        navigationController.navigateToDashboardFragment(R.id.frameLayout)
    }

    override fun onBackPressed() {
        if (this.supportFragmentManager.fragments.last() is GameDetailFragment)
            super.onBackPressed()
    }
}