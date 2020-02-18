package com.ozan.modularapp.injection.module

import com.ozan.core.injection.scope.ActivityScope
import com.ozan.game.presentation.GamesActivityModule
import com.ozan.modularapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [GamesActivityModule::class]
)
internal abstract class ActivityModule {
    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributeMainActivityInjector(): MainActivity
}