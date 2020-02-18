package com.ozan.core.navigation.features

import androidx.fragment.app.Fragment
import com.ozan.core.navigation.PACKAGE_NAME
import com.ozan.core.navigation.loadFragmentOrReturnNull

object GamesFragment : Feature<Fragment> {

    private const val GAMES_FRAGMENT =
        "$PACKAGE_NAME.game.presentation.GamesFragment"

    override val dynamicStart: Fragment?
        get() = GAMES_FRAGMENT.loadFragmentOrReturnNull()
}
