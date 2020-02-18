package com.ozan.core.navigation.features

import android.content.Intent
import com.ozan.core.navigation.PACKAGE_NAME
import com.ozan.core.navigation.loadIntentOrReturnNull

object GamesActivity : Feature<Intent> {

    private const val MAIN = "$PACKAGE_NAME.game.presentation.GamesActivity"

    override val dynamicStart: Intent?
        get() = MAIN.loadIntentOrReturnNull()
}
