package com.ozan.game.domain

import com.ozan.core.domain.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GameDomainModule {

    @Provides
    fun provideGamesUseCase(gameRepository: GameRepository):
            UseCase.FlowRetrieveUseCase<GamesUseCase.Params, GamesResponse> =
        GamesUseCase(gameRepository)

    @Provides
    fun provideGameUseCase(gameRepository: GameRepository):
            UseCase.FlowRetrieveUseCase<GameDetailUseCase.Params, GameDetail> =
        GameDetailUseCase(gameRepository)
}