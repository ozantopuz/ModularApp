package com.ozan.core.navigation.controller

import android.content.Intent
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import java.lang.ref.WeakReference

interface NavigationController {

    val activity: WeakReference<FragmentActivity>

    fun start(intent: Intent?) {
        intent?.let {
            activity.get()?.startActivity(it)
        }
    }

    fun start(
        fragment: Fragment?,
        @IdRes containerId: Int,
        transaction: FragmentTransaction.() -> FragmentTransaction = {
            replace(containerId, fragment!!)
        }
    ) {
        fragment?.let {
            activity.get()?.supportFragmentManager?.beginTransaction()?.transaction()?.commit()
        }
    }

    fun navigateToGamesActivity()

    fun navigateToDashboardFragment(containerId: Int)

    fun navigateToGameDetailFragment(containerId: Int, gameId: Int)
}
