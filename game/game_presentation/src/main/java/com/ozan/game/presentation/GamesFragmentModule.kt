package com.ozan.game.presentation

import com.ozan.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GamesFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [GamePresentationModule::class])
    abstract fun contributeDashboardFragmentInjector(): GamesFragment
}