package com.ozan.modularapp.injection.module

import androidx.lifecycle.ViewModelProvider
import com.ozan.core.presentation.viewmodel.VmFactory
import com.ozan.game.presentation.gamedetail.GameDetailViewModelModule
import com.ozan.game.presentation.games.GamesViewModelModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        GamesViewModelModule::class,
        GameDetailViewModelModule::class
    ]
)
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(vmFactory: VmFactory): ViewModelProvider.Factory
}