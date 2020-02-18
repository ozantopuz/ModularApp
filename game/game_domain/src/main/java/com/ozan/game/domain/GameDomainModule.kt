package com.ozan.game.domain

import com.ozan.core.domain.Interactor
import dagger.Module
import dagger.Provides

@Module
class GameDomainModule {

    @Provides
    fun provideGamesInteractor(gameRepository: GameRepository):
            Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse> =
      GamesInteractor(gameRepository)

    @Provides
    fun provideGameInteractor(gameRepository: GameRepository):
            Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail> =
        GameDetailInteractor(gameRepository)
}