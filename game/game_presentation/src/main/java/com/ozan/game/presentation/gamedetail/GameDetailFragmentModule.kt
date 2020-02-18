package com.ozan.game.presentation.gamedetail

import com.ozan.core.injection.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GameDetailFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeGameDetailFragmentInjector(): GameDetailFragment
}