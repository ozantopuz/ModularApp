package com.ozan.game.presentation.games

import com.ozan.core.injection.scope.FragmentScope
import com.ozan.game.presentation.GamePresentationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GamesFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [GamePresentationModule::class])
    abstract fun contributeDashboardFragmentInjector(): GamesFragment
}