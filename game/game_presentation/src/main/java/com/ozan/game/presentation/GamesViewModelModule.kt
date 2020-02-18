package com.ozan.game.presentation

import androidx.lifecycle.ViewModel
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.core.presentation.viewmodel.ViewModelKey
import com.ozan.game.domain.Game
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.functions.Function

@Module
abstract class GamesViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GamesViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: GamesViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGameViewEntityMapper(): Function<Game, DisplayItem> =
            GameViewEntityMapper()
    }
}