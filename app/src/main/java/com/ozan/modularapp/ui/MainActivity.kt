package com.ozan.modularapp.ui

import android.os.Bundle
import com.ozan.core.navigation.controller.DefaultNavigationController
import com.ozan.core.navigation.controller.NavigationController
import com.ozan.core.presentation.base.BaseActivity
import com.ozan.core.presentation.navigation.UiNavigation
import com.ozan.modularapp.R
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var navigationController: NavigationController

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val uiNavigation = UiNavigation.ROOT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(this))

        navigationController.navigateToGamesActivity()
    }
}
