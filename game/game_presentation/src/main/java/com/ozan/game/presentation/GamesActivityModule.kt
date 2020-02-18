package com.ozan.game.presentation

import com.ozan.core.injection.scope.ActivityScope
import com.ozan.game.presentation.gamedetail.GameDetailFragmentModule
import com.ozan.game.presentation.games.GamesFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GamesActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        GamesFragmentModule::class,
        GameDetailFragmentModule::class
    ])
    abstract fun provideGamesActivity(): GamesActivity
}