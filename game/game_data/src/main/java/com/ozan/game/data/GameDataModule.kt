package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameRepository
import com.ozan.game.domain.GamesResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GameDataModule {

    @Provides
    @Singleton
    fun provideGameService(retrofit: Retrofit): GameService =
        retrofit.create(GameService::class.java)

    @Provides
    fun provideGamesResponseMapper(): GamesResponseMapper = GamesResponseMapper()

    @Provides
    @Singleton
    fun provideGamesRemoteDataSource(
        gameService: GameService,
        mapper: GamesResponseMapper
    ): DataSource.RetrieveRemoteDataSource<Int, GamesResponse> = GamesRemoteDataSource(gameService, mapper)

    @Provides
    @Singleton
    fun provideGameDetailRemoteDataSource(gameService: GameService): DataSource.RetrieveRemoteDataSource<Int, GameDetail> =
        GameDetailRemoteDataSource(gameService)

    @Provides
    @Singleton
    fun provideGameRepository(
        gamesRemoteDataSource: GamesRemoteDataSource,
        gameDetailRemoteDataSource: GameDetailRemoteDataSource
    ): GameRepository = GameRepositoryImpl(
        gamesRemoteDataSource,
        gameDetailRemoteDataSource
    )
}