package com.ozan.core.navigation.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ozan.core.navigation.PACKAGE_NAME
import com.ozan.core.navigation.loadFragmentOrReturnNull

object GameDetailFragment : Feature<Fragment> {

    const val BUNDLE_GAME_ID = "game_id"

    private const val GAME_DETAIL_FRAGMENT =
        "$PACKAGE_NAME.game.presentation.gamedetail.GameDetailFragment"

    override val dynamicStart: Fragment?
        get() = GAME_DETAIL_FRAGMENT.loadFragmentOrReturnNull()

    fun dynamicStartWithGameId(
        gameId: Int
    ): Fragment? {
        return dynamicStart?.apply {
            val bundle = Bundle()
            bundle.putInt(BUNDLE_GAME_ID, gameId)
            arguments = bundle
        }

    }
}
