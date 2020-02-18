package com.ozan.game.domain;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GamesInteractor_Factory implements Factory<GamesInteractor> {
  private final Provider<GameRepository> gameRepositoryProvider;

  public GamesInteractor_Factory(Provider<GameRepository> gameRepositoryProvider) {
    this.gameRepositoryProvider = gameRepositoryProvider;
  }

  @Override
  public GamesInteractor get() {
    return provideInstance(gameRepositoryProvider);
  }

  public static GamesInteractor provideInstance(Provider<GameRepository> gameRepositoryProvider) {
    return new GamesInteractor(gameRepositoryProvider.get());
  }

  public static GamesInteractor_Factory create(Provider<GameRepository> gameRepositoryProvider) {
    return new GamesInteractor_Factory(gameRepositoryProvider);
  }

  public static GamesInteractor newGamesInteractor(GameRepository gameRepository) {
    return new GamesInteractor(gameRepository);
  }
}
