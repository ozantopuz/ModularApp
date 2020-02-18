package com.ozan.modularapp.ui

import com.ozan.core.presentation.base.BaseActivity
import com.ozan.core.presentation.navigation.UiNavigation
import com.ozan.modularapp.R

class MainActivity : BaseActivity() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val uiNavigation = UiNavigation.ROOT
}
