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
public final class GameDomainModule_ProvideGameInteractorFactory
    implements Factory<
        Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail>> {
  private final GameDomainModule module;

  private final Provider<GameRepository> gameRepositoryProvider;

  public GameDomainModule_ProvideGameInteractorFactory(
      GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    this.module = module;
    this.gameRepositoryProvider = gameRepositoryProvider;
  }

  @Override
  public Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail> get() {
    return provideInstance(module, gameRepositoryProvider);
  }

  public static Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail>
      provideInstance(GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    return proxyProvideGameInteractor(module, gameRepositoryProvider.get());
  }

  public static GameDomainModule_ProvideGameInteractorFactory create(
      GameDomainModule module, Provider<GameRepository> gameRepositoryProvider) {
    return new GameDomainModule_ProvideGameInteractorFactory(module, gameRepositoryProvider);
  }

  public static Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail>
      proxyProvideGameInteractor(GameDomainModule instance, GameRepository gameRepository) {
    return Preconditions.checkNotNull(
        instance.provideGameInteractor(gameRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
