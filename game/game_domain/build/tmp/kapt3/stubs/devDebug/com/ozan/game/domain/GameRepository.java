package com.ozan.game.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/ozan/game/domain/GameRepository;", "", "fetchGameDetail", "Lio/reactivex/Single;", "Lcom/ozan/core/model/DataHolder;", "Lcom/ozan/game/domain/GameDetail;", "id", "", "fetchGames", "Lcom/ozan/game/domain/GamesResponse;", "page", "game_domain_devDebug"})
public abstract interface GameRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ozan.core.model.DataHolder<com.ozan.game.domain.GamesResponse>> fetchGames(int page);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ozan.core.model.DataHolder<com.ozan.game.domain.GameDetail>> fetchGameDetail(int id);
}