package com.ozan.game.domain;

import com.ozan.core.domain.Interactor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameDomainModule_ProvideGamesInteractorFactory
    implements Factory<
        Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse>> {
  private final GameDomainModule module;

  private final Provider<GameRepository> gameRepositoryProvider;

  public GameDomainModule_ProvideGamesInteractorFactory(
      GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    this.module = module;
    this.gameRepositoryProvider = gameRepositoryProvider;
  }

  @Override
  public Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse> get() {
    return provideInstance(module, gameRepositoryProvider);
  }

  public static Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse>
      provideInstance(GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    return proxyProvideGamesInteractor(module, gameRepositoryProvider.get());
  }

  public static GameDomainModule_ProvideGamesInteractorFactory create(
      GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    return new GameDomainModule_ProvideGamesInteractorFactory(module, gameRepositoryProvider);
  }

  public static Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse>
      proxyProvideGamesInteractor(GameDomainModule instance, GameRepository gameRepository) {
    return Preconditions.checkNotNull(
        instance.provideGamesInteractor(gameRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
