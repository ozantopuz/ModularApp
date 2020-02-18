package com.ozan.game.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/ozan/game/domain/GamesResponse;", "", "count", "", "next", "", "previous", "results", "", "Lcom/ozan/game/domain/Game;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNext", "()Ljava/lang/String;", "getPrevious", "getResults", "()Ljava/util/List;", "game_domain_devDebug"})
public final class GamesResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "count")
    private final java.lang.Integer count = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "next")
    private final java.lang.String next = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "previous")
    private final java.lang.String previous = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "results")
    private final java.util.List<com.ozan.game.domain.Game> results = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrevious() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ozan.game.domain.Game> getResults() {
        return null;
    }
    
    public GamesResponse(@org.jetbrains.annotations.Nullable()
    java.lang.Integer count, @org.jetbrains.annotations.Nullable()
    java.lang.String next, @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ozan.game.domain.Game> results) {
        super();
    }
}