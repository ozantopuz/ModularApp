package com.ozan.game.presentation

import com.ozan.core.injection.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GamesActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun provideGamesActivity(): GamesActivity
}