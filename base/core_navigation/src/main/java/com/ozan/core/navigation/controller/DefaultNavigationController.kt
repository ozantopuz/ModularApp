package com.ozan.core.navigation.controller

import androidx.fragment.app.FragmentActivity
import com.ozan.core.navigation.features.GameDetailFragment
import com.ozan.core.navigation.features.GamesActivity
import com.ozan.core.navigation.features.GamesFragment
import java.lang.ref.WeakReference

class DefaultNavigationController constructor(
    override val activity: WeakReference<FragmentActivity>
) : NavigationController {

    override fun navigateToDashboardFragment(containerId: Int) =
        start(GamesFragment.dynamicStart,
            containerId, transaction = {
                replace(containerId, GamesFragment.dynamicStart!!).addToBackStack(null)
            })

    override fun navigateToGamesActivity() = start(GamesActivity.dynamicStart)

    override fun navigateToGameDetailFragment(containerId: Int, gameId: Int) =
        start(
            GameDetailFragment.dynamicStartWithGameId(gameId),
            containerId,
            transaction = {
                replace(
                    containerId,
                    GameDetailFragment.dynamicStartWithGameId(gameId)!!
                ).addToBackStack(null)
            })
}
