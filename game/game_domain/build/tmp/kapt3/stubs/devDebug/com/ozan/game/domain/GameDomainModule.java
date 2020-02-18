package com.ozan.game.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/ozan/game/domain/GameDomainModule;", "", "()V", "provideGameInteractor", "Lcom/ozan/core/domain/Interactor$ReactiveRetrieveInteractor;", "Lcom/ozan/game/domain/GameDetailInteractor$Params;", "Lcom/ozan/game/domain/GameDetail;", "gameRepository", "Lcom/ozan/game/domain/GameRepository;", "provideGamesInteractor", "Lcom/ozan/game/domain/GamesInteractor$Params;", "Lcom/ozan/game/domain/GamesResponse;", "game_domain_devDebug"})
@dagger.Module()
public final class GameDomainModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.ozan.core.domain.Interactor.ReactiveRetrieveInteractor<com.ozan.game.domain.GamesInteractor.Params, com.ozan.game.domain.GamesResponse> provideGamesInteractor(@org.jetbrains.annotations.NotNull()
    com.ozan.game.domain.GameRepository gameRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.ozan.core.domain.Interactor.ReactiveRetrieveInteractor<com.ozan.game.domain.GameDetailInteractor.Params, com.ozan.game.domain.GameDetail> provideGameInteractor(@org.jetbrains.annotations.NotNull()
    com.ozan.game.domain.GameRepository gameRepository) {
        return null;
    }
    
    public GameDomainModule() {
        super();
    }
}