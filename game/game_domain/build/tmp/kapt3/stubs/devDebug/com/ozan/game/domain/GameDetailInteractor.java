package com.ozan.game.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/ozan/game/domain/GameDetailInteractor;", "Lcom/ozan/core/domain/Interactor$ReactiveRetrieveInteractor;", "Lcom/ozan/game/domain/GameDetailInteractor$Params;", "Lcom/ozan/game/domain/GameDetail;", "gameRepository", "Lcom/ozan/game/domain/GameRepository;", "(Lcom/ozan/game/domain/GameRepository;)V", "execute", "Lio/reactivex/Observable;", "Lcom/ozan/core/model/DataHolder;", "params", "Params", "game_domain_devDebug"})
public final class GameDetailInteractor implements com.ozan.core.domain.Interactor.ReactiveRetrieveInteractor<com.ozan.game.domain.GameDetailInteractor.Params, com.ozan.game.domain.GameDetail> {
    private final com.ozan.game.domain.GameRepository gameRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ozan.core.model.DataHolder<com.ozan.game.domain.GameDetail>> execute(@org.jetbrains.annotations.NotNull()
    com.ozan.game.domain.GameDetailInteractor.Params params) {
        return null;
    }
    
    @javax.inject.Inject()
    public GameDetailInteractor(@org.jetbrains.annotations.NotNull()
    com.ozan.game.domain.GameRepository gameRepository) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ozan/game/domain/GameDetailInteractor$Params;", "Lcom/ozan/core/domain/Interactor$Params;", "id", "", "(I)V", "getId", "()I", "game_domain_devDebug"})
    public static final class Params extends com.ozan.core.domain.Interactor.Params {
        private final int id = 0;
        
        public final int getId() {
            return 0;
        }
        
        public Params(int id) {
            super();
        }
    }
}