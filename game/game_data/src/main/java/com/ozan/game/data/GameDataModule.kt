package com.ozan.game.data

import com.ozan.core.data.source.DataSource
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameRepository
import com.ozan.game.domain.GamesResponse
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GameDataModule {

    @Provides
    @Singleton
    fun provideGameServices(retrofit: Retrofit): GameServices =
        retrofit.create(GameServices::class.java)

    @Provides
    @Singleton
    fun provideGamesRemoteDataSource(gameServices: GameServices): DataSource.RetrieveRemoteDataSource<Int, GamesResponse> =
        GamesRemoteDataSource(gameServices)

    @Provides
    @Singleton
    fun provideGameDetailRemoteDataSource(gameServices: GameServices): DataSource.RetrieveRemoteDataSource<Int, GameDetail> =
        GameDetailRemoteDataSource(gameServices)

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