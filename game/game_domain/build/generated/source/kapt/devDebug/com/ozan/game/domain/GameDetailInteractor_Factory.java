package com.ozan.game.domain;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameDetailInteractor_Factory implements Factory<GameDetailInteractor> {
  private final Provider<GameRepository> gameRepositoryProvider;

  public GameDetailInteractor_Factory(Provider<GameRepository> gameRepositoryProvider) {
    this.gameRepositoryProvider = gameRepositoryProvider;
  }

  @Override
  public GameDetailInteractor get() {
    return provideInstance(gameRepositoryProvider);
  }

  public static GameDetailInteractor provideInstance(
      Provider<GameRepository> gameRepositoryProvider) {
    return new GameDetailInteractor(gameRepositoryProvider.get());
  }

  public static GameDetailInteractor_Factory create(
      Provider<GameRepository> gameRepositoryProvider) {
    return new GameDetailInteractor_Factory(gameRepositoryProvider);
  }

  public static GameDetailInteractor newGameDetailInteractor(GameRepository gameRepository) {
    return new GameDetailInteractor(gameRepository);
  }
}
